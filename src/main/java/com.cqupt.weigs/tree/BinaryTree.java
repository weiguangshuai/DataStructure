package com.cqupt.weigs.tree;

/**
 * @author weigs
 * @date 2017/6/4 0004
 */
public class BinaryTree {
    class Node{
        public Object data;
        public Node lchild;
        public Node rchild;

        public Node(Object data) {
            this.data = data;
            this.lchild = null;
            this.rchild = null;
        }

        //根节点
        private Node root = null;
        private Node node = null;
    }
}
