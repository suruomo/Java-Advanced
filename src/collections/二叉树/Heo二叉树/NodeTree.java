package collections.二叉树.Heo二叉树;

import java.util.ArrayList;
import java.util.List;

public class NodeTree {
    // 左子节点
    public NodeTree leftNode;
    // 右子节点
    public NodeTree rightNode;

    // 当前结点的值
    public HeroNode heroNode;

    // 插入 数据
    public void add(HeroNode  v) {
        // 如果当前节点没有值，就把数据放在当前节点上
        if (null == heroNode)
            heroNode = v;

            // 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
        else {
            // 新增的值，比当前值小或者相同

            if ( v.hp - heroNode.hp<= 0) {
                if (null == leftNode)
                    leftNode = new NodeTree();
                leftNode.add(v);
            }
            // 新增的值，比当前值大
            else {
                if (null == rightNode)
                    rightNode = new NodeTree();
                rightNode.add(v);
            }

        }

    }
    // 中序遍历所有的节点
    public List<HeroNode> inOrder() {
        List<HeroNode> values = new ArrayList<>();

        // 左节点的遍历结果
        if (null != leftNode){
            values.addAll(leftNode.inOrder());
        }
        // 当前节点
        values.add(heroNode);
        // 右节点的遍历结果
        if (null != rightNode){
            values.addAll(rightNode.inOrder());
        }
        return values;
    }
    public static void main(String[] args) {
        NodeTree roots = new NodeTree();
        System.out.println("初始化十个英雄如下：");
        for(int i=0;i<10;i++){
            HeroNode heroNode=new HeroNode("hero"+i,(float)Math.random()*100);
            roots.add(heroNode);
            System.out.println(heroNode.name+"的血量是："+heroNode.hp);
        }
        System.out.println("按照血量倒序排序如下：");
        List<HeroNode> list=roots.inOrder();
        for(int i=list.size()-1;i>=0;i--){
            System.out.println("血量："+list.get(i).hp);
        }
    }
}
