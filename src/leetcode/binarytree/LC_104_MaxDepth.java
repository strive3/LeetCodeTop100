package leetcode.binarytree;
//给定一个二叉树 root ，返回其最大深度。
//
// 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
//
//
//
// 示例 1：
//
//
//
//
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：3
//
//
// 示例 2：
//
//
//输入：root = [1,null,2]
//输出：2
//
//
//
//
// 提示：
//
//
// 树中节点的数量在 [0, 10⁴] 区间内。
// -100 <= Node.val <= 100
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1830 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author duxiaopeng
 * @Date 2024/5/22 10:36
 * @Description
 * 104-二叉树的最大深度
 */
public class LC_104_MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int i = 0;
        int j = 0;

        if (root.left != null) {
            i += maxDepth(root.left);
        } if (root.right != null) {
            j += maxDepth(root.right);
        }
        return Math.max(i, j) + 1;
    }

    // 采用广度优先遍历
    public int maxDepth2(TreeNode root) {
        int result = 0;
        if (root == null) return result;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);


        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

            }
            result ++;

        }
        return result;

    }


}
