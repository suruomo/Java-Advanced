package 集合框架.ArrayList和LinkedList比较;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
头部插入100000数据，比较速度
 */
public class TestInsert {
    public static void main(String[] args) {
        int n=100000;
        List<Integer> list;
        list=new ArrayList<>();
        long start=System.currentTimeMillis();
        for(int i=0;i<n;i++){
            list.add(0,5);
        }
        long end=System.currentTimeMillis();
        System.out.println("ArrayList耗时："+(end-start)+"ms");
        list=new LinkedList<>();
        start=System.currentTimeMillis();
        for(int i=0;i<n;i++){
            list.add(0,5);
        }
        end=System.currentTimeMillis();
        System.out.println("LinkedList耗时："+(end-start)+"ms");
    }
}
