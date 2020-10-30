import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 文本输入与输出
 */
public class Test3 {
    Logger logger = LoggerFactory.getLogger(Test3.class);

    /**
     * 1234被存储为字符
     */
    @Test
    public void saveWithString() {
        try {
            Writer out = new OutputStreamWriter(new FileOutputStream(
                    "src/test/resources/test3/out1.txt"
            ));
            out.write("1234");
            out.close();
            Reader reader = new InputStreamReader(new FileInputStream(
                    "src/test/resources/test3/out1.txt"
            ));
            byte b = (byte) reader.read();
            while (b != -1) {
                logger.info(String.valueOf(b));
                b = (byte) reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1234被存储为数字
     */
    @Test
    public void saveWithInt() {
        try {
            DataOutputStream dataOutputStream =
                    new DataOutputStream(new FileOutputStream("src/test/resources/test3/out1.txt"));
            dataOutputStream.writeInt(1234);
            DataInputStream dataInputStream = new DataInputStream(
                    new FileInputStream("src/test/resources/test3/out1.txt")
            );
            int b =  dataInputStream.readInt();
            logger.info("["+b+"]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

