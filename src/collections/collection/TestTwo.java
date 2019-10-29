package collections.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 首先初始化一个List,长度是10，值是0-9。
 * 然后不断的shuffle(随机打乱顺序），直到前3位出现
 * 3 1 4
 *
 * shuffle 1000,000 次，统计出现的概率
 * @author 苏若墨
 */
public class TestTwo {
    public static void main(String[] args) {
       List<Integer> lists=new ArrayList<>(10);
       for(int i=0;i<10;i++){
           lists.add(i);
       }
       int n=1000000;
       int num=0;
       for(int j=0;j<n;j++){
            if(lists.get(0)==3&&lists.get(1)==1&&lists.get(2)==4){
                num++;
              }
            Collections.shuffle(lists);
       }
       double rate=(double) num/1000000;
       System.out.println("出现了"+num+"次\n"+"概率为"+rate+"%");
    }
}
