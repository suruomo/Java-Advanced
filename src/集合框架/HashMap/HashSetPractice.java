package 集合框架.HashMap;

import java.util.HashSet;

/*
创建一个长度是100的字符串数组
使用长度是2的随机字符填充该字符串数组
统计这个字符串数组里重复的字符串有多少种
使用HashSet来解决这个问题
 */
public class HashSetPractice {
    public static void main(String[] args) {
    String randchar[]=new String[100];
        String s= "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXTZ";//62
        HashSet<String> randomchar = new HashSet<String>();
        HashSet<String> randomchar1 = new HashSet<String>();   //放重复值
        for (int i = 0; i < 100; i++) {
            int n1=(int)(Math.random()*62);
            int n2=(int)(Math.random()*62);
            System.out.println(String.valueOf(s.charAt(n1))+String.valueOf(s.charAt(n2)));
            String temp = String.valueOf(s.charAt(n1))+String.valueOf(s.charAt(n2));
            if(randomchar.add(temp)==false) {//如果已经存在了temp为key的情况，则add失败
                randomchar1.add(temp);     //加入重复set中
            }

        }
        System.out.println("重复的字符串有："+randomchar1.size()+"个");
        for(String temp:randomchar1) {
            System.out.println(temp);
        }
    }
}
