package leetcode.listnode;
//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
//
// 图示两个链表在节点 c1 开始相交：
//
//
//
// 题目数据 保证 整个链式结构中不存在环。
//
// 注意，函数返回结果后，链表必须 保持其原始结构 。
//
// 自定义评测：
//
// 评测系统 的输入如下（你设计的程序 不适用 此输入）：
//
//
// intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
// listA - 第一个链表
// listB - 第二个链表
// skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
// skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
//
//
// 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视
//作正确答案 。
//
//
//
// 示例 1：
//
//
//
//
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2,
//skipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//— 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。换句话说，它们在内
//存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。
//
//
//
//
// 示例 2：
//
//
//
//
//输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
//1
//输出：Intersected at '2'
//解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
//在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
//
//
// 示例 3：
//
//
//
//
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//这两个链表不相交，因此返回 null 。
//
//
//
//
// 提示：
//
//
// listA 中节点数目为 m
// listB 中节点数目为 n
// 1 <= m, n <= 3 * 10⁴
// 1 <= Node.val <= 10⁵
// 0 <= skipA <= m
// 0 <= skipB <= n
// 如果 listA 和 listB 没有交点，intersectVal 为 0
// 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]
//
//
//
//
// 进阶：你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？
//
// Related Topics 哈希表 链表 双指针 👍 2465 👎 0

/**
 * leetcode 160-相交链表
 */
public class LC_160_IntersectionNode {

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
        // A+B:4 1 8 4 5 null   5    6 1 8 4 5
        // B+A:5 6 1 8 4 5      null 4 1 8 4 5
        while (pointA != pointB) {// 这里比较的是链表的地址（包含后续的指针），因此当相等于的时候 可以直接结束
            // pointA.next 存在null 节点   这里直接判断pointA是否为空，也就是从链表头开始判断，直至链表尾的null节点
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
