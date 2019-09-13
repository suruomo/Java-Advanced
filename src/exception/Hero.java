package exception;

/**
 * 自定义异常
 * 在Hero的attack方法中，当发现敌方英雄的血量为0的时候，抛出该异常
 * 1. 创建一个EnemyHeroIsDeadException实例
 * 2. 通过throw 抛出该异常
 * 3. 当前方法通过 throws 抛出该异常
 * @author 苏若墨
 */
public class Hero {
    public String name;
    protected float hp;

    public void attackHero(Hero h) throws EnemyHeroIsDeadException{   //攻击方法抛出异常
        if(h.hp == 0){
            throw new EnemyHeroIsDeadException(h.name + " 已经挂了,不需要施放技能" );
        }
    }

    @Override
    public String toString(){
        return name;
    }

    class EnemyHeroIsDeadException extends Exception{        //自定义异常

        public EnemyHeroIsDeadException(){

        }
        public EnemyHeroIsDeadException(String msg){
            super(msg);
        }
    }

    public static void main(String[] args) {

        Hero garen =  new Hero();
        garen.name = "盖伦";
        garen.hp = 616;

        Hero teemo =  new Hero();
        teemo.name = "提莫";
        teemo.hp = 0;

        try {
            garen.attackHero(teemo);

        } catch (EnemyHeroIsDeadException e) {
            // TODO Auto-generated catch block
            System.out.println("异常的具体原因:"+e.getMessage());
            e.printStackTrace();
        }

    }
}
