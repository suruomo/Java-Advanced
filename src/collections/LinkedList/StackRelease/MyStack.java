package collections.LinkedList.StackRelease;

import collections.arraylist.Hero;

import java.util.LinkedList;

/**
 * @author 苏若墨
 */
public class MyStack implements Stack {
    public static void main(String[] args) {
      MyStack myStack=new MyStack();
      System.out.println("进栈操作：");
      for(int i=0;i<5;i++){
          Hero hero=new Hero("hero"+i);
          myStack.push(hero);
          System.out.println("hero"+i+"已进栈");
      }
      System.out.println("查看最后一个英雄："+myStack.peek());
      System.out.println("出栈操作:");
        for(int i=0;i<5;i++){
            Hero hero=myStack.pull();
            System.out.println(hero+"已出栈");
        }
    }
    LinkedList<Hero> stack=new LinkedList<Hero>();
    @Override
    public void push(Hero h) {
        stack.addLast(h);
    }

    @Override
    public Hero pull() {
        Hero hero=stack.removeLast();
        return  hero;
    }

    @Override
    public Hero peek() {
        Hero hero=stack.getLast();
        return  hero;
    }
}
