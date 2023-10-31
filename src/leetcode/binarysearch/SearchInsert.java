package leetcode.binarysearch;

/**
 * 35. 搜索插入位置-二分查找
 */
public class SearchInsert {

    public static int searchInsert(int[] nums, int target) {
        if (nums == null) return 0;

        int mid = nums.length / 2;
        // 定义两个指针 low 和 head
        int low = 0;
        int head = nums.length - 1;
        // 如果 target < low 返回 low， 如果 target > head 返回 head + 1。
        if (target > nums[head]) {
            return head + 1;
        } else if (target < nums[low]) {
            return low;
        }
        //
        while (true) {
            // 二分查找，找见之后直接返回
            if (nums[mid] == target) {
                return mid;
            }
            // 如果 low == mid  返回 low + 1
            if (mid == low) {
                return low + 1;
            }
            // 挪动 head 和 low 指针
            if (nums[mid] < target) {
                low = mid;
                mid = (low + head) / 2;
            } else {
                head = mid;
                mid = head / 2;
            }

        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }
}
