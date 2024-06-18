package leetcode.binarytree;

/**
 * @Author duxiaopeng
 * @Date 2024/5/22 10:35
 * @Description TODO
 */
public class TreeNode {

   int val;
   TreeNode left;
   TreeNode right;
   TreeNode() {}
   TreeNode(int val) { this.val = val; }
   TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
   }
}
