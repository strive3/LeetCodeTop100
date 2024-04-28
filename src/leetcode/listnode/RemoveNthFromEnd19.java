package leetcode.listnode;
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
//
//
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
// Related Topics 链表 双指针 👍 2852 👎 0
/**
 * @Author duxiaopeng
 * @Date 2024/4/28 21:34
 * @Description 19-删除链表的倒数第 N 个结点
 * 思路：1. 快慢指针，快指针先走n步，然后快慢指针一起走，快指针走到末尾，慢指针指向要删除的节点的前一个节点，删除即可。
 */
public class RemoveNthFromEnd19 {

   public ListNode removeNthFromEnd(ListNode head, int n) {
      // 虚拟头节点 不需要对头节点进行特殊处理
      ListNode dummy = new ListNode(0, head);

      // 快慢指针
      ListNode quick = dummy;
      ListNode slow = dummy;

      // 快指针先走n步
      while (quick != null && n > 0) {
         quick = quick.next;
         n --;
      }

      // 如果快指针已经到头，则不用再循环，负责快慢指针一起走
      if (quick.next == null) {
         slow.next = slow.next.next;
      } else {
         while (quick.next != null) {
            quick = quick.next;
            slow = slow.next;
            if (quick.next == null) {
               slow.next = slow.next.next;
            }
         }
      }

      return dummy.next;
   }
}
