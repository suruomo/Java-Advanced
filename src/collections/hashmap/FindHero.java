package 集合框架.HashMap;

import 集合框架.ArrayList.Hero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/*
准备一个ArrayList其中存放3000000(三百万个)Hero对象，其名称是随机的,格式是hero-[4位随机数]
hero-3229
hero-6232
hero-9365
...

因为总数很大，所以几乎每种都有重复，把名字叫做 hero-5555的所有对象找出来
要求使用两种办法来寻找
1. 不使用HashMap，直接使用for循环找出来，并统计花费的时间
2. 借助HashMap，找出结果，并统计花费的时间
 */
public class FindHero {
    public static void main(String[] args) {
        List<Hero> heros=new ArrayList<>();
        int n=3000000;
        for(int i=0;i<n;i++){
            heros.add(new Hero("hero-"+(Math.random()*9000)+1000));
        }
        long start=System.currentTimeMillis();
        for(int i=0;i<heros.size();i++){
            if(heros.get(i).name.equals("hero-5555")){
                System.out.println(heros.get(i));
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("for循环耗时："+(end-start)+"ms");
        HashMap<Hero,String> heroList=new HashMap<>();
        for(int i=0;i<n;i++){
            heroList.put(heros.get(i),heros.get(i).name);
        }
        Set<Hero> set=heroList.keySet();
        long st=System.currentTimeMillis();
        for(Hero h:set){
           if(h.name.equals("hero-5555")){
               System.out.println(h);
           }
        }
        long ed=System.currentTimeMillis();
        System.out.println("HashMap循环耗时："+(ed-st)+"ms");
    }
}
