package IO操作;

import java.io.File;

/*

一般说来操作系统都会安装在C盘，所以会有一个 C:\WINDOWS目录。

遍历这个目录下所有的文件(不用遍历子目录)

找出这些文件里，最大的和最小(非0)的那个文件，打印出他们的文件名
 */
public class FindLongest {
    public static void main(String[] args) {
        File fe=new File("C:\\WINDOWS");
        File[] files=fe.listFiles();   //以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        float file_max=Float.MIN_VALUE;
        float file_min=Float.MAX_VALUE;
        File max_file = null;
        File min_file = null;
        for(File f:files){
            if(f.length()>file_max){
                file_max=f.length();
                max_file=f;
            }
            if(f.length()<file_min){
                file_min=f.length();
                min_file=f;
            }
        }
        System.out.println("最大的文件是" + max_file.getAbsolutePath() + ",其大小是" + file_max + "字节");
        System.out.println("最小的文件是" + min_file.getAbsolutePath() + ",其大小是" + file_min + "字节");
    }
}
