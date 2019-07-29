package 集合框架.ArrayList和LinkedList比较;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
比较 ArrayList和LinkedList 在最后面插入100000条数据，谁快谁慢？为什么？
 */
public class TestInsertPost {
    public static void main(String[] args) {
        List<Integer> l;
        l=new ArrayList<>();
        insert(l,"ArrayList");
        l=new LinkedList<>();
        insert(l,"LinkedList");
    }

    private static void insert(List<Integer> l, String type) {
        int n=100000;
        long start=System.currentTimeMillis();
        for(int i=0;i<n;i++){
            l.add(1);
        }
        long end=System.currentTimeMillis();
        System.out.printf("%s末尾插入100000数据耗时%d毫秒%n",type,end-start);
    }
}
