package leetcode.tree;

/**
 * 关键理解：oneSideMaxPath函数返回的是啥
 *
 * 二叉树中的最大路径和
 *
 * 二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「分解问题」的思维。
 * 这题需要巧用二叉树的后序遍历
 * oneSideMaxPath 计算「单边」最大路径和
 */
public class Q124 {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        oneSideMaxPath(root);
        return res;
    }
    public int oneSideMaxPath(TreeNode root) {
        if (root == null) return 0;
        int leftNum = Math.max(0, oneSideMaxPath(root.left));
        int rightNum = Math.max(0, oneSideMaxPath(root.right));
        res = Math.max(res, leftNum+rightNum+root.val);
        return Math.max(leftNum,rightNum) + root.val;
    }
}