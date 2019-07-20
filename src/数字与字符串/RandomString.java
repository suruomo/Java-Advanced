package 数字与字符串;
/*
    //ASCII码表0-9对应48-57
    //A-Z对应65-90
    //a-z对应97-122
 */
public class RandomString {
    public static void main(String[] args) {
           String str=randomString(10);//生成10位随机字符串
           System.out.println(str);
    }

    public static String randomString(int length) {
        char list[]=new char[length];
        int i=0;
        while(i<length){
            char c=(char) (Math.random()*123);
            if((c>='0'&&c<='9')||(c>='a'&&c<='z')||(c>='A'&&c<='Z')){
                list[i++]=c;
            }
        }
        String str=new String(list);
        return str;
    }
}
