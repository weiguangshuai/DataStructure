package com.cqupt.weigs.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author weigs
 * @date 2017/6/4 0004
 */
public class BinaryTree {
    class Node {
        public Object data;
        public Node lchild;
        public Node rchild;

        public Node(Object data, Node lchild, Node rchild) {
            this.data = data;
            this.lchild = lchild;
            this.rchild = rchild;
        }
    }

    private Node root;
    private List<Node> list = new ArrayList<>();

    public BinaryTree() {
        init();
    }

    //树的初始化：先从叶节点开始，由叶到根
    public void init() {
        Node x = new Node("X", null, null);
        Node y = new Node("Y", null, null);
        Node d = new Node("D", x, y);
        Node e = new Node("E", null, null);
        Node f = new Node("F", null, null);
        Node c = new Node("C", e, f);
        Node b = new Node("B", d, null);
        Node a = new Node("A", b, c);
        root = a;


    }

    /**
     * 对二叉树进行先序遍历，结果存储到list中
     */
    public void preOrder(Node node) {
        list.add(node);//先将根节点存入list
        //如果左子树不为空继续往左找，在递归调用方法的时候一直会将子树的根存入list，这就做到了先遍历根节点
        if (node.lchild != null) {
            preOrder(node.lchild);
        }
        //无论走到哪一层，只要当前节点左子树为空，那么就可以在右子树上遍历，保证了根左右的遍历顺序
        if (node.rchild != null) {
            preOrder(node.rchild);
        }
    }

    /**
     * 对二叉树进行中序遍历，结果存储到list中
     *
     * @param node
     */
    public void inOrder(Node node) {
        if (node.lchild != null) {
            inOrder(node.lchild);
        }

        list.add(node);

        if (node.rchild != null) {
            inOrder(node.rchild);
        }
    }


    /**
     * 对二叉树进行后序遍历，结果保存到list中
     *
     * @param node
     */
    public void postOrder(Node node) {
        if (node.lchild != null) {
            postOrder(node.lchild);
        }
        if (node.rchild != null) {
            postOrder(node.rchild);
        }
        list.add(node);
    }

    /**
     * 层次遍历
     *
     * @param node
     */
    public void levelOrder(Node node) {
        LinkedList<Node> linkedList = new LinkedList<>();
        Node current = null;
        linkedList.offer(node);//将根节点入队

        while (!linkedList.isEmpty()) {
            current = linkedList.poll();
            System.out.print(current.data+" ");
            if (current.lchild != null) {
                linkedList.offer(current.lchild);
            }
            if (current.rchild != null) {
                linkedList.offer(current.rchild);
            }

        }

    }


    /**
     * 返回当前树的深度
     *
     * @param node
     * @return
     */
    public int getTreeDepth(Node node) {

        if (node.lchild == null && node.rchild == null) {
            return 1;
        }
        int left = 0, right = 0;
        if (node.lchild != null) {
            left = getTreeDepth(node.lchild);
        }

        if (node.rchild != null) {
            right = getTreeDepth(node.rchild);
        }

        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        //测试先序遍历
//        binaryTree.preOrder(binaryTree.root);
//        for (Node node : binaryTree.getList()) {
//            System.out.print(node.data + " ");
//        }
        //测试中序遍历
//        binaryTree.inOrder(binaryTree.root);
//        for (Node node : binaryTree.getList()) {
//            System.out.print(node.data + " ");
//        }

        //测试后序遍历
//        binaryTree.postOrder(binaryTree.root);
//        for (Node node : binaryTree.getList()) {
//            System.out.print(node.data + " ");
//        }

        //层次遍历
        binaryTree.levelOrder(binaryTree.root);
        for (Node node : binaryTree.getList()) {
            System.out.print(node.data + " ");
        }

        System.out.println("树的深度：" + binaryTree
                .getTreeDepth(binaryTree.root));

    }

    public List<Node> getList() {
        return list;
    }
}
