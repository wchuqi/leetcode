/**
 * 给你一棵完全二叉树，请按以下要求的顺序收集它的全部节点：
 *
 * 依次从左到右，每次收集并删除所有的叶子节点
 * 重复如上过程直到整棵树为空
 * 示例:
 * 输入: [1,2,3,4,5]
 *       1
 *      / \
 *     2   3
 *    / \
 *   4   5
 * 输出: [[4,5,3],[2],[1]]
 * 解释:
 *
 * 删除叶子节点 [4,5,3] ，得到如下树结构：
 * 1 / 2
 * 现在删去叶子节点 [2] ，得到如下树结构：
 * 1
 * 现在删去叶子节点 [1] ，得到空树：
 * []
 * 思路:
 * 我们发现根据子树的高度来分组的
 *
 * 比如示例中 4, 5, 3高度都是0，2是1，1是2
 */
package leetcode.tree;

import java.util.*;

public class Q366 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        root.left = left1;
        root.right = right1;

        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(5);
        left1.left = left2;
        left1.right = right2;

//        System.out.println(maxDepth(root));
//        System.out.println(maxDepth(root.left));
//        System.out.println(maxDepth(root.right));
//        System.out.println(maxDepth(left1.left));
//        System.out.println(maxDepth(left1.right));
        List<List<Integer>> res = findLeaves(root);
        System.out.println(res);
    }
    private static Map<Integer, List<Integer>> maps = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
    public static List<List<Integer>> findLeaves(TreeNode root) {
//        int rootDepth = maxDepth(root);
        traverse(root);
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : maps.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public static void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        traverse(root.right);
        int tempDepth = maxDepth(root);
        if (maps.containsKey(tempDepth)) {
            maps.get(tempDepth).add(root.val);
        } else {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            maps.put(tempDepth, temp);
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
