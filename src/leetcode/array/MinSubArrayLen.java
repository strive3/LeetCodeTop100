package leetcode.array;
//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
// 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返
//回其长度。如果不存在符合条件的子数组，返回 0 。
//
//
//
// 示例 1：
//
//
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//
//
// 示例 2：
//
//
//输入：target = 4, nums = [1,4,4]
//输出：1
//
//
// 示例 3：
//
//
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= target <= 10⁹
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁵
//
//
//
//
// 进阶：
//
//
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
//
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 2122 👎 0

/**
 * @Author duxiaopeng
 * @Date 2024/4/18 22:47
 * @Description TODO
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        // j 代表滑动窗口的终止位置
        int sum = 0;
        // 返回结果
        int result = 0;
        // 起始位置要放在外面定义，因为 sum = sum - nums[i]; 已经把i的值减掉了，因此i不能放在for循环中定义
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            // 滑动窗口元素的汇总值
            sum += nums[j];

            while (sum >= target) {
                sum = sum - nums[i];
                if (result == 0 || result > j - i + 1) {
                    result = j - i + 1;
                }
                i ++;
            }
        }
        return result;
    }
}
