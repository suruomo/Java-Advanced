package collections.arraylist;

/**
 * Hero信息类
 * @author 苏若墨
 */
public class Hero {
    public String name;
    public float hp;
    public int damage;

    public Hero() {}
    /**
     * 增加一个初始化name的构造方法
     * @param name
     */
    public Hero(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
    }

    public Hero(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

}