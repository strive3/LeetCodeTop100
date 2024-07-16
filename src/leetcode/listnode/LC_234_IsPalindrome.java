package leetcode.listnode;
//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,2,1]
//输出：true
//
//
// 示例 2：
//
//
//输入：head = [1,2]
//输出：false
//
//
//
//
// 提示：
//
//
// 链表中节点数目在范围[1, 10⁵] 内
// 0 <= Node.val <= 9
//
//
//
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
//
// Related Topics 栈 递归 链表 双指针 👍 1926 👎 0

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * @Author duxiaopeng
 * @Date 2024/7/16 21:55
 * @Description 234-回文链表
 */
public class LC_234_IsPalindrome {

    // 使用栈，因为是回文链表，所以现将元素放入栈中，再从栈中取出并与原链表对比，即可判断是否是回文链表
    public boolean isPalindrome(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        boolean result = true;

        ListNode point = head;
        while (point != null) {
            stack.push(point);
            point = point.next;
        }

        while (head != null) {
            if (head.val != stack.pop().val){
                result = false;
            }
            head = head.next;
        }
        return result;
    }

    public boolean isPalindrome2(ListNode head) {
        boolean result = true;

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        // 1 2 2 1 null
        // 1 2 3 2 1 null

        while (fast != null && fast.next != null) {
            ListNode next = slow.next;
            // 由于fast slow 的初始值都是head，因此，不能一上来就修改slow.next  必须先修改slow的引用，否则修改next节点会影响到fast
            if (prev != null) slow.next = prev;
            prev = slow;
            slow = next;
            fast = fast.next.next;
        }
        // 针对奇数节点，多翻转了一个节点，因此慢指针需后移动；
        if (fast != null) slow = slow.next;

        while (slow != null) {
            if (slow.val != prev.val) {
                result = false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return result;
    }


    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(1);
        head1.next = head2;
        head1.next.next = head3;
        head1.next.next.next = head4;
        LC_234_IsPalindrome lc234IsPalindrome = new LC_234_IsPalindrome();
        lc234IsPalindrome.isPalindrome2(head1);
    }
}
