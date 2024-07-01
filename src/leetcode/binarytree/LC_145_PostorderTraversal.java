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

import java.util.ArrayList;
import java.util.List;

/**
 * @Author duxiaopeng
 * @Date 2024/7/1 21:57
 * @Description 145-二叉树的后序遍历
 */
public class LC_145_PostorderTraversal {
   public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<Integer>();
      inOrder(root, result);
      return result;
   }

   private void inOrder(TreeNode root, List<Integer> result) {
      if (root == null) return;
      inOrder(root.left, result);
      inOrder(root.right, result);
      result.add(root.val);
   }
}
