package com.cqupt.weigs.tree;

/**
 * @author weigs
 * @date 2017/6/26 0026
 */
public class TreeNode {
    private Object tData; //存储的数据
    private int parent; //父亲节点的下标

    public TreeNode(Object tData, int parent) {
        this.tData = tData;
        this.parent = parent;
    }

    public Object gettData() {
        return tData;
    }

    public void settData(Object tData) {
        this.tData = tData;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }
}
