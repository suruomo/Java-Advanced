package 集合框架.ArrayList;

import 集合框架.ArrayList.Hero;

import java.util.ArrayList;
import java.util.List;

/*
首先初始化一个Hero集合，里面放100个Hero对象，名称分别是从
hero 0
hero 1
hero 2
...
hero 99.

通过遍历的手段，删除掉名字编号是8的倍数的对象
 */
public class RemoveHero {
    public static void main(String[] args) {
        List<Hero> list=new ArrayList<>();
        for(int i=0;i<100;i++){
            list.add(new Hero("hero"+i));
        }
        for(int j=0;j<list.size();j++){
            if(j%8==0&&j!=0){
                list.remove(j);
                System.out.println(j+"号已移除");
            }
        }
    }
}
