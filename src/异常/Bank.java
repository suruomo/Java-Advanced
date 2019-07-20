package 异常;

import java.util.Scanner;

public class Bank {
    private int account;   //账户
    private double balance;   //余额
    public  double getBalance(){   //获取余额
        return balance;
    }
    public  void deposit(){  //存钱
        System.out.println("请输入您要存的数额：");
        Scanner sc=new Scanner(System.in);
        double money=sc.nextDouble();
        balance+=money;
    }
    public  void withdraw() throws OverdraftException{ //取钱
        System.out.println("请输入您要取出的数额：");
        Scanner sc=new Scanner(System.in);
        double money=sc.nextDouble();
        if(money<=balance){
            System.out.println("成功取钱"+money);
        }
        else{
            double deficit=money-balance;
            throw new OverdraftException("您已经透支"+deficit);
        }
    }
    private class OverdraftException extends Exception {
        public OverdraftException(){}
        public OverdraftException(String message){
            super(message);
        }
    }
    public static void main(String[] args) {
       Bank bank=new Bank();
       System.out.println("请输入您的操作（1存钱 2取钱 )");
       Scanner sc=new Scanner(System.in);
       int op=sc.nextInt();
       try{
           switch (op){
               case 1:
                   bank.deposit();
               case 2:
                   bank.withdraw();
           }
       }catch (OverdraftException e){
             e.printStackTrace();
       }

    }


}
