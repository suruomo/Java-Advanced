package thread.线程池.java自带线程池;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*线程池类ThreadPoolExecutor在包java.util.concurrent下

ThreadPoolExecutor threadPool= new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

第一个参数10 表示这个线程池初始化了10个线程在里面工作
第二个参数15 表示如果10个线程不够用了，就会自动增加到最多15个线程
第三个参数60 结合第四个参数TimeUnit.SECONDS，表示经过60秒，多出来的线程还没有接到活儿，就会回收，最后保持池子里就10个
第四个参数TimeUnit.SECONDS 如上
第五个参数 new LinkedBlockingQueue() 用来放任务的集合*/
public class TestOne {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(10,15, 60,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务中。。。");
            }
        });
    }
}
