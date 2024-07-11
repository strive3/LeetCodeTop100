package leetcode.binarytree;
//给定一个二叉树，判断它是否是 平衡二叉树
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
//
//
// 示例 3：
//
//
//输入：root = []
//输出：true
//
//
//
//
// 提示：
//
//
// 树中的节点数在范围 [0, 5000] 内
// -10⁴ <= Node.val <= 10⁴
//
//
// Related Topics 树 深度优先搜索 二叉树 👍 1529 👎 0


/**
 * @Author duxiaopeng
 * @Date 2024/7/11 21:56
 * @Description 110-平衡二叉树
 */
public class LC_110_IsBalanced {

   public boolean isBalanced(TreeNode root) {
      return getHeight(root) >= 0;
   }

   // 递归写法  参考后序遍历
   private int getHeight(TreeNode node) {
      // 递归终止条件
      if (node == null) return 0;
      // 左子树高度  如果是-1，表示不是平衡二叉树
      int leftHeight = getHeight(node.left);
      if (leftHeight == -1) return -1;
      // 右子树高度
      int rightHeight = getHeight(node.right);
      if (rightHeight == -1) return -1;
      // 当前节点高度 （中）
      if (Math.abs(leftHeight - rightHeight) > 1) {
         return -1;
      } else {
         // 计算当前节点高度 最大子节点高度+1
         return Math.max(leftHeight, rightHeight) + 1;
      }
   }
}
