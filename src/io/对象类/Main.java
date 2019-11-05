package io.对象类;

import java.io.*;

/**
 * 测试类
 * @author 苏若墨
 */
public class Main {
    public static void main(String[] args) {
        Hero hero=new Hero();
        hero.hp=100;
        hero.name="傻逼";
        File file=new File("C://WINDOWS");
        try(FileOutputStream fos=new FileOutputStream(file); ObjectOutputStream oos=new ObjectOutputStream(fos);
        FileInputStream fis=new FileInputStream(file);ObjectInputStream ois=new ObjectInputStream(fis)
        ){
            oos.writeObject(hero);
            Hero h2 = (Hero) ois.readObject();
            System.out.println(h2.name);
            System.out.println(h2.hp);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
