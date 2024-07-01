package leetcode.binarytree;
//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,2,3]
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
// 示例 4：
//
//
//输入：root = [1,2]
//输出：[1,2]
//
//
// 示例 5：
//
//
//输入：root = [1,null,2]
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1254 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author duxiaopeng
 * @Date 2024/7/1 21:53
 * @Description 144-二叉树的前序遍历
 */
public class LC_144_PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preOrder(root, result);

        return result;
    }


    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        // 根节点压栈
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode tempNode = stack.pop();
            // 处理顺序  中 左 右
            result.add(tempNode.val);
            // 空元素不压栈
            if (tempNode.right != null) stack.push(tempNode.right);
            if (tempNode.left != null) stack.push(tempNode.left);
        }

        return result;
    }

    private void preOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);

    }
}
