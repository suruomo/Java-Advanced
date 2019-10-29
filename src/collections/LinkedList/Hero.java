package collections.LinkedList;

/**
 * @author 苏若墨
 */
public class Hero {
    public String name;
    public float hp;

    public int damage;

    public Hero() {

    }


    /**
     * 增加一个初始化name的构造方法
     * @param name
     */
    public Hero(String name) {

        this.name = name;
    }


    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return name;
    }

}