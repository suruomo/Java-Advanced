package 集合框架.ArrayList和LinkedList比较;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestQuery {
    public static void main(String[] args) {
        int n=100000;
        List<Integer> list;
        list=new ArrayList<>();
        query(list,"ArrayList");
        list=new LinkedList<>();
        query(list,"LinkedList");
    }

    private static void query(List<Integer> list, String type) {
        int n=10000;
        int index=n/2;
        //初始化
        for(int i=0;i<n;i++){
            list.add(5);
        }
        //查询
        long start = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            int t = list.get(index);
            t++;
            list.set(index, t);
        }
        long end = System.currentTimeMillis();
        System.out.printf("%s总长度是%d，定位到第%d个数据，取出来，加1，再放回去%n 重复%d遍，总共耗时 %d 毫秒 %n", type,n, index,n, end - start);
        System.out.println();
    }
}
