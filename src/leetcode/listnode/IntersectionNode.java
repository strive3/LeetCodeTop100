package leetcode.listnode;

/**
 * leetcode 160 相交链表
 */
public class IntersectionNode {

    /**
     * 有两个链表 链表A 和链表B
     * 找出相交链表的初始节点，因此首先要统一两个需遍历链表的长度
     * 假如链表A  [4,1,8,4,5]
     * 链表B   [5,6,1,8,4,5]
     * 因此 链表A 从头开始遍历，链表B 从第二个节点开始遍历，使用双指针同时往后遍历，找出相同的节点，并且返回
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 如果两个链表为空，则返回空
        if (headA == null || headB == null) return null;
        // 使用双指针，初始化两个链表的指针
        ListNode pointA = headA;
        ListNode pointB = headB;
        // 求出两个链表的长度
        int lengthA = length(headA);
        int lengthB = length(headB);
        // 找出遍历链表的开始位置
        if (lengthA > lengthB) {
            int dif = lengthA - lengthB;
            while (dif-- > 0) {
                pointA = pointA.next;
            }
        } else {
            int dif = lengthB - lengthA;
            while (dif-- > 0) {
                pointB = pointB.next;
            }
        }
        // 遍历链表，如果链表A节点==链表B节点，则返回
        while (pointA != pointB) {
            pointA = pointA.next;
            pointB = pointB.next;
        }
        return pointA;
    }

    private int length(ListNode list) {
        int length = 0;
        while (list != null) {
            list = list.next;
            length ++;
        }
        return length;
    }

    /**
     * 解法2
     * 链表A 长度 a+c
     * 链表B 长度 b+c
     * 若 链表A 遍历完链表A 再去遍历链表B 则是： a + c + b
     * 链表B 遍历完链表B 再去遍历链表A 则是 b + c + a
     * 因此接下来的节点 就是相交节点
     * 若不存在相交节点，则会出现 null == null 的 情况
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        // 如果两个链表为空，则返回空
        if (headA == null || headB == null) return null;
        // 使用双指针，初始化两个链表的指针
        ListNode pointA = headA;
        ListNode pointB = headB;
        while (pointA != pointB) {
            pointA = pointA == null ? headB : pointA.next;
            pointB = pointB == null ? headA : pointB.next;
        }
        return pointA;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
