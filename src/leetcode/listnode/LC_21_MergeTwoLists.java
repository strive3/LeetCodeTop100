package leetcode.listnode;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
//
// 示例 2：
//
//
//输入：l1 = [], l2 = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：l1 = [], l2 = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列
//
//
// Related Topics 递归 链表 👍 3495 👎 0


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
 * @Date 2024/4/26 23:38
 * @Description 21-合并两个有序链表 思路：遍历两个链表，取小的值，然后移动指针
 */
public class LC_21_MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       if (list1 == null && list2 == null) return null;

       // 定义返回的链表
       ListNode head = new ListNode();
       // 移动链表的指针
       ListNode cur = head;
       while (list1 != null && list2 != null) {
          // 遍历两个链表，取小的值
          if (list2 == null || list1.val < list2.val) {
             cur.val = list1.val;
             list1 = list1.next;
          } else {
             cur.val = list2.val;
             list2 = list2.next;
          }
          // 移动指针
          cur.next = new ListNode();
          cur = cur.next;
       }

       // 处理剩余的链表
       if (list1 != null) {
          cur.val = list1.val;
          cur.next = list1.next;
       } else if (list2 != null) {
          cur.val = list2.val;
          cur.next = list2.next;
       }
       return head;
    }

    public static void main(String[] args) {
       ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
       ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
       LC_21_MergeTwoLists mergeTwoLists = new LC_21_MergeTwoLists();
       ListNode listNode = mergeTwoLists.mergeTwoLists(list1, list2);
       System.out.println(listNode);
    }
}
