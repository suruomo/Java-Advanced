package lambda;

import collections.arraylist.Hero;

/**
 * lambda表达式所用的函数是接口：只能有一个抽象方法
 * @author 苏若墨
 */
public interface HeroChecker {
    public boolean test(Hero h);
}