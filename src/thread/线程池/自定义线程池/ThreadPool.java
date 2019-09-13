package thread.线程池.自定义线程池;

import java.util.LinkedList;

public class ThreadPool {
    // 线程池大小
    int threadPoolSize;

    // 任务容器
    LinkedList<Thread> tasks = new LinkedList<Thread>();

    public ThreadPool() {       //线程池初始化
        threadPoolSize = 10;

        // 启动10个任务消费者线程
        synchronized (tasks) {
            for (int i = 0; i < threadPoolSize; i++) {
                new TaskConsumeThread("任务消费者线程 " + i).start();
            }
        }
    }

    public void add(Thread r) {
        synchronized (tasks) {
            tasks.add(r);
            // 唤醒等待的任务消费者线程
            tasks.notifyAll();
        }
    }

    class TaskConsumeThread extends Thread {         //消费线程类
        public TaskConsumeThread(String name) {
            super(name);
        }

        Thread task;

        public void run() {
            System.out.println("启动： " + this.getName());
            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {  //任务容器为空时，所有线程wait
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    task = tasks.removeLast(); //取出该任务准备执行
                    // 允许添加任务的线程可以继续添加任务
                    tasks.notifyAll();
                }
                System.out.println(this.getName() + " 获取到任务，并执行");
                task.run();
            }
        }
    }

}