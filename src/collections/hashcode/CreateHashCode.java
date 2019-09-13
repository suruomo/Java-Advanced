package collections.hashcode;
/**
 * 自定义一个简单的hashcode算法，计算任意字符串的hashcode:
 *
 * 如果字符串长度是0，则返回0。
 * 否则： 获取每一位字符，转换成数字后，相加，最后乘以23
 * (s[0]+ s[1] + s[2] + s[3]+ s[n-1])*23.
 * 如果值超过了1999，则取2000的余数，保证落在0-1999之间。
 * 如果是负数，则取绝对值。
 * 随机生成长度是2-10的不等的100个字符串，打印用本hashcode获取的值分别是多少
 */
public class CreateHashCode {
    public static void main(String[] args) {
        int n=20;
        for(int i=0;i<n;i++){
            String s=String.valueOf((int)(10+Math.random()*90) );
            System.out.println(s+"的hashcode是"+hashCode(s));
        }
    }

    /**
     * 生成hashcode
     * @param s 待求字符串
     * @return hashcode
     */
    private static String hashCode(String s) {
        if(s.length()==0){
            return "0";
        }
        char[] c=s.toCharArray();
        int r=((int)c[0]+(int)c[1])*23;
        return String.valueOf(r);
    }
}
