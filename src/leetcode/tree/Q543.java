package leetcode.tree;

/**
 * 关键理解：maxDepth函数返回的是啥
 *
 * 二叉树的直径
 * 直径，就是左右子树的最大深度之和，最深肯定就是最大的
 *
 * 所谓二叉树的直径，就是左右子树的最大深度之和，
 * 那么直接的想法是对每个节点计算左右子树的最大高度，得出每个节点的直径，从而得出最大的那个直径。
 * 需要灵活运用二叉树的后序遍历，在 maxDepth 的后序遍历位置顺便计算最大直径。
 */
public class Q543 {
    int res = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        maxDepth(root);
        return res;
    }
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        res = Math.max(res, left+right);
        return Math.max(left,right)+1;
    }
}
