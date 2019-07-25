package 集合框架.二叉树;

import java.util.ArrayList;
import java.util.List;

public class Node {
    // 左子节点
    public Node leftNode;
    // 右子节点
    public Node rightNode;

    // 当前结点的值
    public Object value;

    // 插入 数据
    public void add(Object v) {
        // 如果当前节点没有值，就把数据放在当前节点上
        if (null == value)
            value = v;

            // 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
        else {
            // 新增的值，比当前值小或者相同

            if ((Integer) v -((Integer)value) <= 0) {
                if (null == leftNode)
                    leftNode = new Node();
                leftNode.add(v);
            }
            // 新增的值，比当前值大
            else {
                if (null == rightNode)
                    rightNode = new Node();
                rightNode.add(v);
            }

        }

    }
    // 中序遍历所有的节点
    public List<Object> inOrder() {
        List<Object> values = new ArrayList<>();

        // 左节点的遍历结果
        if (null != leftNode){
            values.addAll(leftNode.inOrder());
        }
        // 当前节点
        values.add(value);
        // 右节点的遍历结果
        if (null != rightNode){
            values.addAll(rightNode.inOrder());
        }
        return values;
    }
    // 前遍历所有的节点
    public List<Object> preOrder() {
        List<Object> values = new ArrayList<>();
        // 当前节点
        values.add(value);
        // 左节点的遍历结果
        if (null != leftNode){
            values.addAll(leftNode.inOrder());
        }

        // 右节点的遍历结果
        if (null != rightNode){
            values.addAll(rightNode.inOrder());
        }
        return values;
    }
    // 前遍历所有的节点
    public List<Object> postOrder() {
        List<Object> values = new ArrayList<>();

        // 左节点的遍历结果
        if (null != leftNode){
            values.addAll(leftNode.inOrder());
        }

        // 右节点的遍历结果
        if (null != rightNode){
            values.addAll(rightNode.inOrder());
        }
        // 当前节点
        values.add(value);
        return values;
    }
    public static void main(String[] args) {

        int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };

        Node roots = new Node();
        for (int number : randoms) {
            roots.add(number);
        }
        System.out.println("中序遍历结果如下：");
        System.out.println(roots.inOrder());
        System.out.println("前序遍历结果如下：");
        System.out.println(roots.preOrder());
        System.out.println("后序遍历结果如下：");
        System.out.println(roots.postOrder());
    }
}
