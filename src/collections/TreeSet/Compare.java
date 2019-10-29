package collections.TreeSet;

import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;


/**
 *默认情况下，TreeSet中的数据是从小到大排序的，不过TreeSet的构造方法支持传入一个Comparator
 *
 * public TreeSet(Comparator comparator)
 *
 * 通过这个构造方法创建一个TreeSet，使得其中的的数字是倒排序的
 * @author 苏若墨
 */
public class Compare {
    public static void main(String[] args) {
        Comparator<Integer> c=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2) {
                    return 1;
                }
                else if (o1>o2) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
        };
        //自定义倒序比较器
        TreeSet<Integer> ts=new TreeSet<>(c);
        Random random=new Random();
        while(true) {
            ts.add(random.nextInt(99));
            if(ts.size()>=20) {
                break;
            }
        }
        System.out.println("对TreeSet倒序排序的结果为：");
        System.out.println(ts);
    }
}
