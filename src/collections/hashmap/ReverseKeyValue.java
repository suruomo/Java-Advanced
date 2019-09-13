package collections.hashmap;

import collections.arraylist.Hero;

import java.util.HashMap;

/**
 * 使用如下键值对，初始化一个HashMap：
 * adc - 物理英雄
 * apc - 魔法英雄
 * t - 坦克
 *
 * 对这个HashMap进行反转，key变成value,value变成key
 * @author 苏若墨
 */
public class ReverseKeyValue {
    public static void main(String[] args) {
        HashMap<String, Hero> before=new HashMap<>();
        before.put("abc",new Hero("物理英雄"));
        before.put("apc",new Hero("魔法英雄"));
        before.put("t",new Hero("坦克"));
        System.out.println("反转前HashMap内容如下：");
        for(String s:before.keySet()){
            System.out.println(s+"-"+before.get(s));
        }
        //反转
        HashMap<Hero, String> newHM=new HashMap<>();
        for(String str:before.keySet()){
            newHM.put(before.get(str), str);
        }
        System.out.println("反转后HashMap内容如下：");
        for(Hero o:newHM.keySet()){
            System.out.println(o.name+"-"+newHM.get(o));
        }

    }
}
