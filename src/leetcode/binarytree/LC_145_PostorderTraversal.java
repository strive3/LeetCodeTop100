package leetcode.binarytree;

//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[3,2,1]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1180 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * @Author duxiaopeng
 * @Date 2024/7/1 21:57
 * @Description 145-二叉树的后序遍历
 * 前序：中 左 右
 * 后序：左 右 中
 */
public class LC_145_PostorderTraversal {
   public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<Integer>();
      postOrder(root, result);
      return result;
   }

   public List<Integer> postorderTraversal2(TreeNode root) {
      List<Integer> result = new ArrayList<Integer>();
      if (root == null) return result;

      Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
      stack.push(root);
      while (!stack.isEmpty()) {
         TreeNode tempNode = stack.pop();

         result.add(tempNode.val);

         if (tempNode.left != null) stack.push(tempNode.left);
         if (tempNode.right != null) stack.push(tempNode.right);
      }
      // 集合中是 中 右 左， 反转之后 就是后序遍历的结果
      Collections.reverse(result);

      return result;
   }

   private void postOrder(TreeNode root, List<Integer> result) {
      if (root == null) return;
      postOrder(root.left, result);
      postOrder(root.right, result);
      result.add(root.val);
   }
}
