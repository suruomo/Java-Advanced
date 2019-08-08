package 多线程.练习;

import java.io.*;

/*
遍历所有文件，当遍历到文件是.java的时候，创建一个线程去查找这个文件的内容(有没有static关键字），
不必等待这个线程结束，继续遍历下一个文件
 */
public class SearchFile {
    public static void main(String[] args) {
        File file=new File("D:\\Java\\Project\\practice\\src");
        String s="static";
        long start=System.currentTimeMillis();
        search(file,s);
        long end=System.currentTimeMillis();
        System.out.printf("耗时:%dms",end-start);
    }

    private static void search(File file, String s) {
        if(file.exists()){     //文件夹是否存在
            if(file.isDirectory()){   //文件是否是目录
                 File[] files=file.listFiles();
                 for(File file1:files){
                     search(file1,s);   //递归继续查找
                 }
            }else if(file.isFile()&&file.getName().endsWith(".java")){  //若是文件且以.java结束
                 Thread thread=new Thread(){
                     @Override
                     public void run() {
                         searchInFile(file, s);
                     }
                 };
                 thread.start(); //开启线程
                 return;          //跳出递归
            }
        }else{
            System.out.println("文件夹不存在");

        }
    }

    private static void searchInFile(File file, String s) {
        try(FileReader fileReader=new FileReader(file);BufferedReader br=new BufferedReader(fileReader) ){
            while (true){
                String line=br.readLine();
                if(line==null){
                    break;
                }
                if(line.contains(s)){         //包含static
                    System.out.println("含“static”字符串的文件有："+file.getAbsolutePath());
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
