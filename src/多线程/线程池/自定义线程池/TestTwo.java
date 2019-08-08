package 多线程.线程池.自定义线程池;
/*创造一个情景，每个任务执行的时间都是1秒
刚开始是间隔1秒钟向线程池中添加任务

然后间隔时间越来越短，执行任务的线程还没有来得及结束，新的任务又来了。
就会观察到线程池里的其他线程被唤醒来执行这些任务
*/
public class TestTwo {
    public static void main(String
                                    [] args) {
        ThreadPool pool= new ThreadPool();
        int sleep=1000;
        while(true){
            pool.add(new Thread(){      //线程池中添加新任务
                @Override
                public void run() {
                    System.out.println("执行任务ing...");
                }
            });
            try {
                Thread.sleep(sleep);        //休眠时间越来越短
                sleep = sleep>100?sleep-100:sleep;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }
}