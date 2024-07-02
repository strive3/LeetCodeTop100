package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 2098 👎 0
/**
 * @Author du-xp
 * @Date 2024/7/1
 * @Description 94-二叉树的中序遍历 递归+循环
 * 左中右
 *
 * 1、确定递归函数的参数和返回值（一般是void，可以把想要的值直接放到方法参数中）
 * 2、确定终止条件
 * 3、确定单层递归的逻辑
 */
public class LC_94_InorderTraversal {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        // 递归
//        inOrder(root);

        // 迭代
        // 遍历二叉树的指针
        TreeNode cur = root;
        // 因为递归是通过栈来实现的，因此迭代法 等同于模拟递归
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.empty()) {
            // 不为空，则push进栈
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                // 为空则pop出栈
                TreeNode temp = stack.pop();
                result.add(temp.val);
                cur = temp.right;
            }
        }
        return result;
    }

    // 1、确定递归函数的参数和返回值（一般是void，可以把想要的值直接放到方法参数中）
    public void inOrder(TreeNode root) {
        // 2、确定终止条件
        if (root == null) return;
        // 3、确定单层递归的逻辑
        inOrder(root.left);
        result.add(root.val);
        inOrder(root.right);
    }


}
