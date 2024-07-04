package leetcode.binarytree;
//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
//
//
// 示例 2：
//
//
//输入：root = [1]
//输出：[[1]]
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
// 树中节点数目在范围 [0, 2000] 内
// -1000 <= Node.val <= 1000
//
//
// Related Topics 树 广度优先搜索 二叉树 👍 1979 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author duxiaopeng
 * @Date 2024/7/4 22:03
 * @Description 102-二叉树的层序遍历
 */
public class LC_102_LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 初始化返回值
        List<List<Integer>> returnList = new ArrayList<List<Integer>>();

        if (root == null) return returnList;
        // 声明一个队列，
        Deque<TreeNode> queue = new ArrayDeque();
        // 将根元素先加入到队列中
        queue.addLast(root);

        // 每一层树结构进行 一次外层循环，            循环的终止条件也就是队列为空
        while (!queue.isEmpty()) {
            // 存储本层级的元素数量
            List<Integer> levelList = new ArrayList<>();
            // 由于外层循环是一层树结构遍历完成， 因此 size 存储的是当前层有多少节点
            int size = queue.size();
            // 遍历这一层级的元素 size 用来标明这层有多少元素，要从队列中 取出多少元素
            while (size > 0) {
                TreeNode indexNode = queue.removeFirst();
                levelList.add(indexNode.val);
                if (indexNode.left != null) queue.addLast(indexNode.left);
                if (indexNode.right != null) queue.addLast(indexNode.right);
                size --;
            }
            returnList.add(levelList);
        }
        return returnList;
    }
}
