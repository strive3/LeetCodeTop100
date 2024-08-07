package leetcode.listnode;
//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
//
//
// 示例 2：
//
//
//输入：head = [], val = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [7,7,7,7], val = 7
//输出：[]
//
//
//
//
// 提示：
//
//
// 列表中的节点数目在范围 [0, 10⁴] 内
// 1 <= Node.val <= 50
// 0 <= val <= 50
//
//
// Related Topics 递归 链表 👍 1415 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * @Author duxiaopeng
 * @Date 2024/4/20 15:00
 * @Description 203-移除链表元素  使用虚拟头节点的目的是 保证每个节点的删除逻辑都是一样的
 */
public class LC_203_RemoveElements {
   public ListNode removeElements(ListNode head, int val) {
      //虚拟头节点
      ListNode dummyHead = new ListNode();
      // 给虚拟头节点赋值
      dummyHead.next = head;

      ListNode cur = dummyHead;
      while (cur.next != null) {
         if (cur.next.val == val) {
            cur.next = cur.next.next;
//            cur = cur.next;
         } else {
            // 不需要删除则游标后移
            cur = cur.next;
         }
      }
      return dummyHead.next;
   }
}
