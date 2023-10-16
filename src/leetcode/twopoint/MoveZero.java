package leetcode.twopoint;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * 进阶：你能尽量减少完成的操作次数吗？
 *
 * 思路：
 * 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
 * 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
 * 注意到以下性质：
 * 左指针左边均为非零数；
 * 右指针左边直到左指针处均为零。
 * 因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。
 */
public class MoveZero {
    public static void moveZeroes(int[] nums) {
        // right 右指针，left 左指针  ,均必须从0开始
        int right = 0;
        for (int left = 0; left < nums.length; left++) {
            if (nums[left] != 0) {
                // 交换 (注意，非0元素也会做交换（第一个元素）)
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right ++;
            }
        }
        Arrays.stream(nums).forEach(e -> System.out.println(e));
    }

    public static void main(String[] args) {
        int[] arrs = new int[] {1, 0, 1, 0, 3, 12};
        moveZeroes(arrs);
    }
}
