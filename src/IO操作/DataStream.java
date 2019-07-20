package IO操作;

import java.io.*;

/*
DataInputStream 数据输入流
DataOutputStream 数据输出流
 要用DataInputStream 读取一个文件，这个文件必须是由DataOutputStream 写出的，
 否则会出现EOFException，因为DataOutputStream 在写出的时候会做一些特殊标记，只有DataInputStream 才能成功的读取。
 */
public class DataStream {
    public static void main(String[] args) {
        write();
        read();
    }

    private static void read() {   //将数据从一个文件读取到另一个文件
        File f =new File("d:/lol.txt");
        try (
                FileInputStream fis  = new FileInputStream(f);
                DataInputStream dis =new DataInputStream(fis);
        ){
            boolean b= dis.readBoolean();
            int i = dis.readInt();
            String str = dis.readUTF();

            System.out.println("读取到布尔值:"+b);
            System.out.println("读取到整数:"+i);
            System.out.println("读取到字符串:"+str);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void write() {    //像一个文件中分别写入布尔值，整型数据以及字符串
        File f =new File("d:/lol.txt");
        try (
                FileOutputStream fos  = new FileOutputStream(f);
                DataOutputStream dos =new DataOutputStream(fos);
        ){
            dos.writeBoolean(true);
            dos.writeInt(300);
            dos.writeUTF("123 this is gareen");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
