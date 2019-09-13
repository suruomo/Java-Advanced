package thread.死锁;

import thread.Hero;

/*
1. 线程1 首先占有对象1，接着试图占有对象2
2. 线程2 首先占有对象2，接着试图占有对象1
3. 线程1 等待线程2释放对象2
4. 与此同时，线程2等待线程1释放对象1
就会。。。一直等待下去，直到天荒地老，海枯石烂，山无棱 ，天地合。。。
 */
public class TestOne {
    public static void main(String[] args) {
        final Hero hero1=new Hero();
        hero1.name="安妮";
        final Hero hero=new Hero();
        hero.name="solo";
        Thread t1=new Thread(){
            @Override
            public void run() {
                synchronized (hero1){
                    System.out.println("t1已经占有安妮");
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("t1 试图占有solo");
                    System.out.println("t1 等待中 。。。。");
                    synchronized (hero) {
                        System.out.println("do something");
                    }
                }
            }
        };
        t1.start();
        Thread t2=new Thread(){
            @Override
            public void run() {
                synchronized (hero){
                    System.out.println("t2已经占有solo");
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("t2 试图占有安妮");
                    System.out.println("t2 等待中 。。。。");
                    synchronized (hero1) {
                        System.out.println("do something");
                    }
                }
            }
        };
        t2.start();
    }
}
