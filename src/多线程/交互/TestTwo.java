package 多线程.交互;

import 多线程.Hero;

/*
在Hero类中：hurt()减血方法：当hp=1的时候，执行this.wait().
this.wait()表示 让占有this的线程等待，并临时释放占有
进入hurt方法的线程必然是减血线程，this.wait()会让减血线程临时释放对this的占有。 这样加血线程，就有机会进入recover()加血方法了。
recover() 加血方法：增加了血量，执行this.notify();
this.notify() 表示通知那些等待在this的线程，可以苏醒过来了。 等待在this的线程，恰恰就是减血线程。
 一旦recover()结束， 加血线程释放了this，减血线程，就可以重新占有this，并执行后面的减血工作。
 */
public class TestTwo {
    public static void main(String[] args) {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;

        Thread t1 = new Thread(){
            public void run(){
                while(true){
                    gareen.hurt();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    gareen.recover();

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t2.start();

    }

}