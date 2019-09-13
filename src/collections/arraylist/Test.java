package 集合框架.ArrayList;

import 集合框架.ArrayList.Hero;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList heros = new ArrayList();

        // 初始化5个对象
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i));
        }
        for(int i=0;i<heros.size();i++){
            if(heros.get(i).toString().equals("hero 1")){
                System.out.println("存在一个name是hero 1的人");
            }
        }

    }
}
