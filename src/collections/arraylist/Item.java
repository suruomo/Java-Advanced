package collections.arraylist;

/**
 * 物品Item信息类
 * @author 苏若墨
 */
public class Item {
    String name;
    int price;

    public Item() {

    }
    /**
     * 提供一个初始化name的构造方法
     * @param name
     */
    public Item(String name) {
        this.name = name;
    }

    /**
     * 物品使用效果函数
     */
    public void effect() {
        System.out.println("物品使用后，可以有效果");
    }

}