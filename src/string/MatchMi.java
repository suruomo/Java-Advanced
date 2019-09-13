package string;
/*
1. 生成一个长度是3的随机字符串，把这个字符串作为当做密码

2. 使用穷举法生成长度是3个字符串，匹配上述生成的密码
 */
public class MatchMi {
    public static void main(String[] args) {
        String str=RandomString.randomString(3);
        System.out.println("原始密码是"+str);
        for(int i=48;i<123;i++){
            for(int j=48;j<123;j++){
                for(int z=48;z<123;z++){
                    if(str.charAt(0)==i&&str.charAt(1)==j&&str.charAt(2)==z){
                        char a=(char)i;
                        char b=(char)j;
                        char c=(char)z;
                        System.out.println("匹配成功，密码是"+a+b+c);
                    }
                }
            }
        }
    }
}
