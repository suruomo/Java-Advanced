package 多线程.继承线程类;

import 多线程.Hero;

public class KillThread extends java.lang.Thread {
    private Hero h1;
    private Hero h2;
    public KillThread(Hero h1,Hero h2){
        this.h1=h1;
        this.h2=h2;
    }
    public void run(){
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}
