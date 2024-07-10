package leetcode.binarytree;
//给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,2,3,4,4,3]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,null,3,null,3]
//输出：false
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [1, 1000] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2743 👎 0

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author duxiaopeng
 * @Date 2024/7/10 23:08
 * @Description 101-对称二叉树
 */
public class LC_101_IsSymmetric {

   // 广度优先遍历
   public boolean isSymmetric(TreeNode root) {
      if (root == null) return true;
      // 将左子树 和 右子树 都放入同一个队列中，遍历的时候，每次弹出两个节点，比较它们的值，如果值不相等，则返回false，
      // 如果值相等，则将两个节点的左右子节点依次放入队列中，继续遍历。
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root.left);
      queue.offer(root.right);

      while (!queue.isEmpty()) {
         TreeNode leftNode = queue.poll();
         TreeNode rightNode = queue.poll();
         // 如果两个节点都为空，则继续遍历下一个节点
         if (leftNode == null && rightNode == null) {
            continue;
         }
         if (leftNode != null && rightNode == null) {
            return false;
         }
         if (leftNode == null && rightNode != null) {
            return false;
         }

         if (leftNode.val != rightNode.val) {
            return false;
         }

         queue.offer(leftNode.left);
         queue.offer(rightNode.right);
         queue.offer(leftNode.right);
         queue.offer(rightNode.left);

      }
      return true;
   }

   public static void main(String[] args) {
      LC_101_IsSymmetric lc101IsSymmetric = new LC_101_IsSymmetric();
      TreeNode root = new TreeNode(9);
      root.left = new TreeNode(-42);
      root.right = new TreeNode(-42);
      root.left.left = null;
      root.left.right = new TreeNode(76);
      root.right.left = null;
      root.right.right = new TreeNode(76);
      root.left.right.left = new TreeNode(13);
      root.left.right.right = null;
      root.right.right.left = new TreeNode(13);
      root.right.right.right = null;
      System.out.println(lc101IsSymmetric.isSymmetric(root));
   }
}
