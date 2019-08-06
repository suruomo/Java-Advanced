package 多线程.交互.多线程交互;

import sun.awt.windows.ThemeReader;

public class Main {
    public static void main(String[] args) {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        for(int i=0;i<2;i++){
            Thread t1=new Thread(){
                @Override
                public void run() {
                    while(true){
                        synchronized (gareen){
                            gareen.recover();
                        }
                        try{
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            t1.start();
        }
        for(int i=0;i<5;i++){
            Thread t2=new Thread(){
                @Override
                public void run() {
                    while(true){
                        synchronized (gareen){
                            gareen.hurt();
                        }
                        try{
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            t2.start();
        }
    }

}
