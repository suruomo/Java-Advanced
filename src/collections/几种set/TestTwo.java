package collections.几种set;

import java.util.LinkedHashSet;

/**
 * 利用LinkedHashSet的既不重复，又有顺序的特性，把Math.PI中的数字，按照出现顺序打印出来，相同数字，只出现一次
 * @author 苏若墨
 */
public class TestTwo {
    public static void main(String[] args) {
        LinkedHashSet<Character> l=new LinkedHashSet<>();
        String s=String.valueOf(Math.PI);
        for(char c:s.toCharArray()){
            if(c=='.')
                continue;
            l.add(c);
        }
        System.out.println(l);
    }
}
