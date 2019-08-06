package 多线程.交互;
/*
假设加血线程运行得更加频繁，英雄的最大血量是1000

设计加血线程和减血线程的交互，让回血回满之后，加血线程等待，直到有减血线程减血
 */
public class TestThree {
    public static void main(String[] args) {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;

        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    gareen.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t1.start();

        Thread t2 = new Thread() {
            public void run() {
                while (true) {
                    gareen.recover();

                    try {
                        Thread.sleep(10);      //加快回血速度
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

