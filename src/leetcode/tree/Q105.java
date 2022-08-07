package leetcode.tree;

/**
 * 构造二叉树，第一件事一定是找根节点，然后想办法构造左右子树。
 *
 * 本质上该算法也就是⼀个前序遍历，因为它在前序遍历的位置加了⼀坨代码。
 *
 */
public class Q105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1,
                inorder, 0, inorder.length-1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        int rootVal = preorder[preStart];
        int index = 0;
        for (int i=inStart;i<=inEnd;i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftLength = index-inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart+1, preStart+leftLength, inorder, inStart, index-1);
        root.right = build(preorder, preStart+leftLength+1,preEnd, inorder, index+1, inEnd);
        return root;
    }
}
