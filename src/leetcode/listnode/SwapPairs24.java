package leetcode.listnode;
//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//
//
// 示例 2：
//
//
//输入：head = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
//
// Related Topics 递归 链表 👍 2203 👎 0
/**
 * @Author duxiaopeng
 * @Date 2024/4/28 22:26
 * @Description 24-两两交换链表中的节点
 *
 * dummy -> 1 -> 2 -> 3 -> 4 -> 5
 * 1.
 * dummy/1 -> 2 -> 3 -> 4 -> 5
 * 2.
 * dummy-> 2/1 -> 3 -> 4 -> 5
 * 3.
 * dummy-> 2 -> 1 -> 3 -> 4 -> 5
 *
 *
 * 终：dummy -> 2 -> 1 -> 4 -> 3 -> 5
 */
public class SwapPairs24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        // 遍历的终止条件：cur.next 和 cur.next.next 都不为空
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next;
            ListNode nextNext = cur.next.next;

            // 交换
            // 将 cur 指向 2
            cur.next = nextNext;
            // 将 1 的 next 指向 3
            next.next = nextNext.next;
            // 将 2 的 next 指向 1
            nextNext.next = next;

            cur = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(new SwapPairs24().swapPairs(listNode));
    }
}
