
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Test1 {
    Logger logger= LoggerFactory.getLogger(Test1.class);
    @Test
    public void rwBite3() throws IOException {
        DataOutputStream dataOutputStream =
                new DataOutputStream(
                        new FileOutputStream("src/test/resources/byte_test1.dat"));
        dataOutputStream.writeInt(1234);
        dataOutputStream.close();


        DataOutputStream dataOutputStream1 =
                new DataOutputStream(
                        new FileOutputStream("src/test/resources/byte_test2.dat"));
        dataOutputStream1.writeChars("1234");
        dataOutputStream1.close();
        Writer dataOutputStream3 =
                new OutputStreamWriter(
                        new FileOutputStream("src/test/resources/byte_test3.dat"),
                        StandardCharsets.UTF_8);
        dataOutputStream3.write("1234");
        dataOutputStream1.close();
    }
    @Test
    public void rwBite2() throws IOException {
        try(FileInputStream fin=new FileInputStream("" +
                "src/test/resources/num_test1.dat")) {

            DataInputStream dataInputStream=new DataInputStream(fin);
            while(dataInputStream.available()>0){
                int k=  dataInputStream.readInt();
                System.out.println(k);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataOutputStream dataOutputStream =
                new DataOutputStream(
                        new FileOutputStream("src/test/resources/num_test1.dat"));

        dataOutputStream.writeInt(123);
        dataOutputStream.writeFloat(123.45F);

        dataOutputStream.writeLong(789);

        dataOutputStream.close();
    }
    @Test
    public void rwBite1(){
        try(FileInputStream fin=new FileInputStream("" +
                "src/test/resources/my_test.txt")) {
            Reader reader=new InputStreamReader(fin);
            int k=reader.read();
            while (k!=-1 ) {
                //System.out.println((char) (k) +"["+k+"]");
                k=reader.read();
                //Thread.sleep(1000);
                //logger.info((char) (b) +"["+b+"]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void rwBite(){
        try(FileInputStream fin=new FileInputStream("" +
                "src/test/resources/my_test.txt")) {
            /*while (fin.available()>0 ) {
                byte b=(byte)fin.read();
                System.out.println((char) (b) +"["+b+"]");
                Thread.sleep(1000);
                //logger.info((char) (b) +"["+b+"]");
            }*/
            int k=fin.available();
            while (k>0 ) {
                byte b=(byte)fin.read();
                System.out.print(k);
                System.out.println((char) (b) +"["+b+"]");
                k=fin.available();
                Thread.sleep(1000);
                //logger.info((char) (b) +"["+b+"]");
            }

            /*logger.info("---------read num--------");
            FileInputStream fin1=new FileInputStream("" +
                    "src/test/resources/num_test.txt");
            DataInputStream din=new DataInputStream(fin);
            double x=din.readDouble();
            logger.info(String.valueOf(x));*/
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
