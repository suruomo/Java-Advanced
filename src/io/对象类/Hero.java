package io.对象类;

import java.io.Serializable;
/*
把一个对象序列化有一个前提是：这个对象的类，必须实现了Serializable接口
 */
public class Hero implements Serializable {
    //表示这个类当前的版本，如果有了变化，比如新设计了属性，就应该修改这个版本号
    private static final long serialVersionUID = 1L;
    public String name;
    public float hp;
}
