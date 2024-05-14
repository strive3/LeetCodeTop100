package leetcode.listnode;
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
//
// Related Topics 递归 链表 数学 👍 10557 👎 0
/**
 * @Author duxiaopeng
 * @Date 2024/4/28 20:50
 * @Description 2-两数相加
 */
public class LC_2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 初始化l1的遍历指针
        ListNode pointL1 = l1;
        // 初始化l2的遍历指针
        ListNode pointL2 = l2;

        // 初始化返回链表
        ListNode rtnListNode = new ListNode();

        // 初始化返回链表的遍历指针
        ListNode pointRtn1 = rtnListNode;

        // 循环遍历两个链表，只有有一个不为空，就继续遍历
        while (pointL1 != null || pointL2 != null) {
            if (pointL1 == null) {
                pointRtn1.val = pointL2.val;
                // 移动l2的遍历指针
                pointL2 = pointL2.next;
            } else if (pointL2 == null) {
                pointRtn1.val = pointL1.val;

                pointL1 = pointL1.next;
            } else {
                pointRtn1.val = pointL1.val + pointL2.val;

                pointL1 = pointL1.next;
                pointL2 = pointL2.next;
            }

            // 如果l1或l2的下一节点指针不为空，就创建新的节点，并且移动返回链表的遍历指针
            if (pointL1 != null || pointL2 != null) {
                pointRtn1.next = new ListNode();
                pointRtn1 = pointRtn1.next;
            }
        }

        // 定义新的返回链表遍历指针
        ListNode pointRtn = rtnListNode;
        // 循环遍历返回链表，如果当前节点的值大于等于10，就取余数，并且移动到下一个节点
        while (pointRtn != null) {
            if (pointRtn.val >= 10) {
                pointRtn.val = pointRtn.val % 10;
                if (pointRtn.next == null) {
                    pointRtn.next = new ListNode();
                }
                // 下一节点值加1
                pointRtn.next.val = pointRtn.next.val + 1;
            }
            // 移动返回链表的遍历指针
            pointRtn = pointRtn.next;
        }

        return rtnListNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(new LC_2_AddTwoNumbers().addTwoNumbers(l1, l2));
    }
}
