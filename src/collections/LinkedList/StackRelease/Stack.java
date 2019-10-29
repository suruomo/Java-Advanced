package collections.LinkedList.StackRelease;

import collections.arraylist.Hero;

/**
 * @author 苏若墨
 */
public interface Stack {

    /**
     * 把英雄h入到最后位置
     * @param h
     */
     void push(Hero h);

    /**
     * 把最后一个英雄取出来
     * @return
     */
     Hero pull();

    /**
     * 查看最后一个英雄
     * @return
     */
     Hero peek();
}
