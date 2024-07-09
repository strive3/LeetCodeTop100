package leetcode.binarytree;
//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
//
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
// 初始状态下，所有 next 指针都被设置为 NULL。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由
//next 指针连接，'#' 标志着每一层的结束。
//
//
//
//
//
// 示例 2:
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
// 树中节点的数量在
// [0, 2¹² - 1] 范围内
// -1000 <= node.val <= 1000
//
//
//
//
// 进阶：
//
//
// 你只能使用常量级额外空间。
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 1122 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author duxiaopeng
 * @Date 2024/7/9 22:20
 * @Description 116-填充每个节点的下一个右侧节点指针
 */
public class LC_116_Connect {
    // 广度优先遍历
    public Node connect(Node root) {
        if (root == null) return root;
        Deque<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            // 先保存一下前一个节点
            Node prev = queue.peek();
            int size = queue.size();
            // 遍历到当前层级的最后一个节点时，，最后一个节点无法成为prev节点，因此使用的是默认值Null
            while (size-- > 0) {
                Node cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                // 如果当前节点等于前一个节点，则不做操作
                if (prev == cur) {
                    continue;
                }
                // 否则将前一个节点的next指针指向当前节点
                prev.next = cur;
                prev = cur;
            }
        }

        return root;
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}


