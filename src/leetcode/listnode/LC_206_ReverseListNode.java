package leetcode.listnode;

/**
 * @Author duxiaopeng
 * @Date 2024/4/17 23:58
 * @Description TODO
 */
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
//
//
//
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
//
//
// 示例 2：
//
//
//输入：head = [1,2]
//输出：[2,1]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 5000]
// -5000 <= Node.val <= 5000
//
//
//
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
//
// Related Topics 递归 链表 👍 3557 👎


//leetcode submit region begin(Prohibit modification and deletion)


// Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//leetcode submit region end(Prohibit modification and deletion)
// 1-> 2-> 3-> 4-> 5-> null
// null <-1 <-2 <-3 <-4 <-5

/**
 * @Author du-xp
 * @Date 2024/4/20
 * @return: null
 * @Description 206-反转链表
 */
public class LC_206_ReverseListNode {
    /**
     * @Author du-xp
     * @Date 2024/4/18
     * @param head:
     * @return: leetcode.listnode.ListNode
     * @Description 双指针解法，current指向当前节点，prev指向上一个节点。
     * 往后移动current，prev指向current，current指向next，递归解法是对该解法的改编
     */
    public ListNode reverseList(ListNode head) {
        //  1 -> 2 -> 3 -> 4 -> 5 -> null
        // current 为指针
        ListNode current = head;
        // prev 为指针
        ListNode prev = null;

        while (current != null) {
            // ******由于指向下一节点的指针后续要去掉，因此这次暂时保存一下 下一个节点******
            ListNode next = current.next;
            // 将当前节点指向前一个节点
            //  1 -> 2 -> 3 -> 4 -> 5 -> null
            //  null <- 1  2 -> 3 -> 4 -> 5 -> null
            current.next = prev;
            // prev 指针向后移动
            prev = current;
            // current 指针向后移动
            current = next;
        }
        return prev;
    }

    public ListNode reverse(ListNode current, ListNode prev) {
        if (current == null) {
            return prev;
        }
        ListNode next = current.next;
        current.next = prev;
        return reverse(next, current);
    }
}
