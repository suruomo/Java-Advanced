package thread.常见线程方法;

import thread.Hero;

/*
sleep	当前线程暂停	示例代码
join	加入到当前线程中	示例代码
setPriority	线程优先级	示例代码
yield	临时暂停	示例代码
setDaemon	守护线程
 */
public class Main {
    public static void main(String[] args) {
        Thread t1= new Thread(){                    //线程休眠
            public void run(){
                int seconds =0;
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了LOL %d 秒%n", seconds++);
                }
            }
        };
        t1.start();

        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 6160;
        gareen.damage = 1;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 3000;
        teemo.damage = 1;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 5000;
        bh.damage = 1;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 4505;
        leesin.damage = 1;

        Thread t= new Thread(){
            public void run(){

                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }
            }
        };

        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    Thread.yield();       //线程暂停
                    bh.attackHero(leesin);
                }
            }
        };

        t.setPriority(Thread.MAX_PRIORITY);            //设置优先级
        t2.setPriority(Thread.MIN_PRIORITY);
        t.start();
        t2.start();

    }

}
