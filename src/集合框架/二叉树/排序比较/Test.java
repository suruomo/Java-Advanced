package 集合框架.二叉树.排序比较;


import 集合框架.二叉树.Node;

/*
创建4万个随机数，然后用分别用冒泡法，选择法，二叉树3种排序算法进行排序，比较哪种更快
 */
public class Test {
    public static void main(String[] args) {
        int n=40000;
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=(int) (Math.random()*1000);
        }
        buble(a);
        select(a);
        binaryTree(a);
    }

    private static void binaryTree(int[] a) {      //二叉排序
        long start=System.currentTimeMillis();
        Node node=new Node();
        for(int i=0;i<a.length;i++){
            node.add(a[i]);
        }
        node.inOrder();
        long end=System.currentTimeMillis();
        System.out.println("二叉排序耗时(ms):"+(end-start));
    }

    private static void select(int[] a) {      //选择排序
        int min=0;
        min=a[0];
        long start=System.currentTimeMillis();
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[j]<min){
                    int t=min;
                    min=a[j];
                    a[j]=t;
                }
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("选择排序耗时(ms):"+(end-start));
    }

    private static void buble(int[] a) {     //冒泡排序
        long start=System.currentTimeMillis();
        boolean flag=true;
        for(int i=0;i<a.length;i++){
            flag=false;
            for(int j=a.length-1;j>i;j--){
                if(a[i]>a[j]){
                    flag=true;
                    int t=a[i];
                    a[i]=a[j];
                    a[j]=t;
                }
            }
            if(flag=false)
                break;
        }
        long end=System.currentTimeMillis();
        System.out.println("冒泡排序耗时(ms):"+(end-start));
    }
}
