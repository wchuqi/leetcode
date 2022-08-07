package leetcode.tree;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * BST 的中序遍历结果是有序的（升序），所以用一个外部变量记录中序遍历结果第 k 个元素即是第 k 小的元素。
 *
 */
public class Q230 {
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }
    int res = 0;
    int rank = 0;
    public void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
