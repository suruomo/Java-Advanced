package 集合框架.HashSet;

import java.util.HashSet;

/*
生成50个 0-9999之间的随机数，要求不能有重复的
解答：
利用hashset无重复特性存储数据
 */
public class Test {
    public static void main(String[] args) {
        HashSet<Integer> lists=new HashSet<>();
        for(int i=0;i<50;i++){
            int t=(int) (Math.random()*9999);
            lists.add(t);
            System.out.println(t);
        }
    }


}
