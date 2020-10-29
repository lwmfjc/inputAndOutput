import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Test2 {
    Logger logger= LoggerFactory.getLogger(Test2.class);

    /**
     * 从文件一个字节一个子节地读
     */
    @Test
    public void stepByByte() {
        try (InputStream inputStream =
                     new FileInputStream
                             ("src/test/resources/reRead/test2_a.txt");
        ) {
            byte b = (byte) inputStream.read();
            while(b!=-1) {
                logger.info((char)(b)+"");
                b = (byte) inputStream.read();
            }
            System.out.println(124234);
            logger.info("abc");
            System.out.println(124234);
            System.out.println(124234);
            System.out.flush();
            System.out.println(124234);
            System.out.println(124234);
            System.out.println(124234);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取stream中可用字节并一次性打印出来
     */
    @Test
    public void stepByAvailableBytes(){
        try(InputStream inputStream=
                    new FileInputStream("src/test/resources/reRead/test2_a.txt")){
            int available=inputStream.available();
            byte[] bytes=new byte[available];
            inputStream.read(bytes);

            String s=new String(bytes);
            logger.info(s);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    @Test
    public void testFlush(){

        try(InputStream inputStream=
                    new FileInputStream("src/test/resources/reRead/test2_a.txt")){
            int available=inputStream.available();
            byte[] bytes=new byte[available];
            inputStream.read(bytes);

            String s=new String(bytes);


            PrintWriter writer = new MyPrintWriter(System.out);
            writer.print("000000000000");
            logger.info("test");
            System.out.println("234234");
          writer.flush();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    class MyPrintWriter extends PrintWriter{


        public MyPrintWriter(OutputStream out) {
            super(out);
        }

        @Override
        public void flush() {
            //super.flush();
            logger.info("调用了flush方法!");
        }
    }
}
