package collections.compare;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 在List的中间位置，插入数据，比较ArrayList快，还是LinkedList快，并解释为什么？
 * @author 苏若墨
 */
public class TeatIsertMiddle {
    public static void main(String[] args) {
        List<Integer> l;
        l=new ArrayList<>();
        insert(l,"Arraylist");
        l=new LinkedList<>();
        insert(l,"LinkedList");
    }

    private static void insert(List<Integer> l, String type) {
        int n=100000;
        int mid=l.size()/2;
        long start=System.currentTimeMillis();
        for(int i=0;i<n;i++){
            l.add(mid,1);
        }
        long end=System.currentTimeMillis();
        System.out.printf("%s中间插入100000条数据耗时：%d ms%n",type,end-start);
    }
}
