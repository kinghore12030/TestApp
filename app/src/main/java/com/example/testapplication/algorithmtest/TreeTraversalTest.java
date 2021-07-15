package com.example.testapplication.algorithmtest;

import java.util.ArrayList;

/**
 * 二叉树遍历
 * Created wangjinhao on 12/24/20.
 */
class TreeTraversalTest {

    private ArrayList preOrderArrayList = new ArrayList();
    private ArrayList inOrderArrayList = new ArrayList();
    private ArrayList postOrdermArrayList = new ArrayList();

    public void preOrder(TreeNode treeNode) {
        if(treeNode == null){
            return;
        }
        preOrderArrayList.add(treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    public void inOrder(TreeNode treeNode) {
        if(treeNode == null){
            return;
        }
        inOrder(treeNode.left);
        inOrderArrayList.add(treeNode.val);
        inOrder(treeNode.right);
    }

    public void postOrder(TreeNode treeNode) {
        if(treeNode == null){
            return;
        }
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        postOrdermArrayList.add(treeNode.val);
    }
}
