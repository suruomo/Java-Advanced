package IO操作;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/*
这是标准的关闭流的方式
1. 首先把流的引用声明在try的外面，如果声明在try里面，其作用域无法抵达finally.
2. 在finally关闭之前，要先判断该引用是否为空
3. 关闭的时候，需要再一次进行try catch处理

这是标准的严谨的关闭流的方式
 */
public class CloseStream {
    public static void main(String[] args) {
        File f = new File("d:/lol.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
            byte[] all = new byte[(int) f.length()];
            fis.read(all);
            for (byte b : all) {
                System.out.println(b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 在finally 里关闭流
            if (null != fis)
                try {

                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }
}
