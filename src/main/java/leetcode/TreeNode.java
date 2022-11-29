package leetcode;

/**
 * 二叉树
 *
 * @author LvYingBin
 * @version 1.0
 * @since 2022/11/29 4:38 下午
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
