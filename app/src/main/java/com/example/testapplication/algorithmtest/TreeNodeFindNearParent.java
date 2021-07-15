package com.example.testapplication.algorithmtest;

/**
 * 在二叉树中找到两个节点的最近公共祖先
 * Created wangjinhao on 12/25/20.
 */
class TreeNodeFindNearParent {
    /**
     *
     * @param root TreeNode类
     * @param o1 int整型
     * @param o2 int整型
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        if(root == null){
            return 0;
        }

        if(root.val == o1 || root.val == o2){
            return root.val;
        }

        int left = lowestCommonAncestor(root.left,o1,o2);
        int right= lowestCommonAncestor(root.right,o1,o2);
        if(left == 0){
            return right;
        }
        if(right == 0){
            return left;
        }
        return root.val;
    }
}
