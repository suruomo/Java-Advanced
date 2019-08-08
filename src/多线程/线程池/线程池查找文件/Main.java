package 多线程.线程池.线程池查找文件;
/*使用java自带的线程池
 *  线程池类ThreadPoolExecutor在包java.util.concurrent下
 *
 *  练习：初始化一个大小是10的线程池，遍历目录下所有文件，当遍历到文件是.java的时候，
 *         创建一个查找文件的任务，把这个任务扔进线程池去执行，继续遍历下一个文件
 * */

import java.io.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        File file=new File("D:\\Java\\Project\\practice\\src");
        String s="static";
        ThreadPoolExecutor threadPool=new ThreadPoolExecutor(
           10,20,60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
       long start=System.currentTimeMillis();
        search(file,s,threadPool);  //开始查找文件
       long end=System.currentTimeMillis();
       System.out.printf("耗时:%dms",end-start);

    }

    private static void search(File file, String s, ThreadPoolExecutor threadPool) {
        if(file.exists()){     //文件夹是否存在
            if(file.isDirectory()){   //文件是否是目录
                File[] files=file.listFiles();
                for(File file1:files){
                    search(file1,s,threadPool);   //递归继续查找
                }
            }else if(file.isFile()&&file.getName().endsWith(".java")){  //若是文件且以.java结束
               threadPool.execute(new Runnable() {
                   @Override
                   public void run() {
                       searchFile(file, s,threadPool);  //查找文件是否包含static关键字
                   }

               });
                return;          //跳出递归
            }
        }else{
            System.out.println("文件夹不存在");

        }
    }
    private static void searchFile(File file, String s, ThreadPoolExecutor threadPool) {
        try(FileReader fileReader=new FileReader(file); BufferedReader br=new BufferedReader(fileReader) ){
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
