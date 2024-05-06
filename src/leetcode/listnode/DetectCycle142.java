package leetcode.listnode;
//给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//
// 不允许修改 链表。
//
//
//
//
//
//
// 示例 1：
//
//
//
//
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//
// 示例 2：
//
//
//
//
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//
// 示例 3：
//
//
//
//
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围在范围 [0, 10⁴] 内
// -10⁵ <= Node.val <= 10⁵
// pos 的值为 -1 或者链表中的一个有效索引
//
//
//
//
// 进阶：你是否可以使用 O(1) 空间解决此题？
//
// Related Topics 哈希表 链表 双指针 👍 2521 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @Author duxiaopeng
 * @Date 2024/4/26 23:25
 * @Description 142-环形链表 II 方法1：哈希表，方法2：快慢指针
 */
public class DetectCycle142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> listNodes = new HashSet<>();
        while (head != null) {
            if (listNodes.contains(head)) {
                return head;
            }
            listNodes.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * @Author du-xp
     * @Date 2024/4/26
     * @param head:
     * @return: leetcode.listnode.ListNode
     * @Description 快慢指针的方法，快指针每次走两步，慢指针每次走一步，如果快慢指针相遇，则说明有环。
     * 快慢指针相遇的节点就是环的入口节点
     * 相遇的节点 到 环的入口节点的距离 = 头节点 到 相遇节点的距离
     *
     * 代码随想录
     * https://www.bilibili.com/list/525438321?tid=0&sort_field=pubtime&spm_id_from=333.999.0.0&oid=300762117&bvid=BV1if4y1d7ob
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode index1 = head;
                ListNode index2 = slow;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
