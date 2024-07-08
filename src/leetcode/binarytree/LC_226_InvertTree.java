package leetcode.binarytree;
//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
//
//
// 示例 2：
//
//
//
//
//输入：root = [2,1,3]
//输出：[2,3,1]
//
//
// 示例 3：
//
//
//输入：root = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点数目范围在 [0, 100] 内
// -100 <= Node.val <= 100
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1826 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author duxiaopeng
 * @Date 2024/7/8 22:35
 * @Description 226-翻转二叉树
 */
public class LC_226_InvertTree {

   // 递归
   public TreeNode invertTree(TreeNode root) {
      if (root == null) return null;
      swap(root);
      invertTree(root.left);
      invertTree(root.right);
      return root;
   }

   // 循环
   // 在循环的过程中对二叉树进行翻转  采取的是层次遍历 参考102题
   public TreeNode invertTree2(TreeNode root) {
      if (root == null) return null;

      Deque<TreeNode> queue = new ArrayDeque();
      // 队列操作方法 等价于 addLast方法
      queue.offer(root);

      while (!queue.isEmpty()) {
         int size = queue.size();

         while (size-- > 0) {
            // 队列操作方法 等价于 removeFirst方法
            TreeNode node = queue.poll();
            swap(node);
            if (node.right != null) queue.offer(node.right);
            if (node.left != null) queue.offer(node.left);
         }
      }
      return root;
   }



   private void swap(TreeNode node) {
      TreeNode temp = node.left;
      node.left = node.right;
      node.right = temp;
   }


}
