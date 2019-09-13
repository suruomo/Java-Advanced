package collections.arraylist;

import java.util.ArrayList;

/**
 * 测试类
 * @author 苏若墨
 */
public class TestOne extends ArrayList {
    @Override
    public boolean add(Object o) {
        if(o instanceof Item ||o instanceof Hero){
            System.out.println("类型正确，可插入");
            return super.add(o);
        }
        else{
            System.out.println("类型不符合，插入失败");
            return false;
        }
    }
    public static void main(String [] args){
        TestOne pl = new TestOne();
        String s = new String("a string");
        Hero hero = new Hero("蒂莫西");
        Item item = new Item("黑刀 - 暗月");
        pl.add(hero);
        pl.add(item);
        pl.add(s);
        System.out.println(pl.toString());
        System.out.println();
    }
}
