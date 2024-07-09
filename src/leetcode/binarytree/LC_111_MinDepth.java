package leetcode.binarytree;
//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明：叶子节点是指没有子节点的节点。
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：2
//
//
// 示例 2：
//
//
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
//
//
//
//
// 提示：
//
//
// 树中节点数的范围在 [0, 10⁵] 内
// -1000 <= Node.val <= 1000
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1202 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author duxiaopeng
 * @Date 2024/7/9 22:48
 * @Description 111-二叉树的最小深度
 */
public class LC_111_MinDepth {
   // 采取广度优先遍历解题
   public int minDepth(TreeNode root) {
      if (root == null) return 0;

      Deque<TreeNode> queue = new ArrayDeque<>();
      queue.offer(root);
      int result = 1;
      while (!queue.isEmpty()) {
         int size = queue.size();
         while (size -- > 0) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            // 如果两个子节点都为空，说明找到了最小深度
            if (node.left == null && node.right == null) {
               return result;
            }
         }
         result++;
      }
      return result;
   }
}
