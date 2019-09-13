package exception;

import java.util.Scanner;

/**
 * 银行信息类
 * @author 苏若墨
 */
public class Bank {
    /**
     * 账户
     */
    private int account;
    /**
     * 余额
     */
    private double balance;

    /**
     * 获取余额
     * @return balance
     */
    public  double getBalance(){
        return balance;
    }

    /**
     * 存钱
     */
    public  void deposit(){
        System.out.println("请输入您要存的数额：");
        Scanner sc=new Scanner(System.in);
        double money=sc.nextDouble();
        balance+=money;
    }

    /**
     * 取钱
     * @throws OverdraftException
     */
    public  void withdraw() throws OverdraftException{
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
                   break;
               case 2:
                   bank.withdraw();
                   break;
               default:
                   break;
           }
       }catch (OverdraftException e){
             e.printStackTrace();
       }

    }


}
