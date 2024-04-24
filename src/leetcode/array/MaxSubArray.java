package leetcode.array;
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。
//
//
//
// 示例 1：
//
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：1
//
//
// 示例 3：
//
//
//输入：nums = [5,4,-1,7,8]
//输出：23
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// -10⁴ <= nums[i] <= 10⁴
//
//
//
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
//
// Related Topics 数组 分治 动态规划 👍 6641 👎 0

/**
 * @Author duxiaopeng
 * @Date 2024/4/24 22:27
 * @Description 53-最大子数组和
 */
public class MaxSubArray {
   public static int maxSubArray(int[] nums) {
      // 初始化结果集，如果为空，则返回0，负责默认赋值第一个元素
      int result = 0;
      if (nums.length == 0) return result;
      if (nums.length > 0) result = nums[0];
      // 存储临时子数组和
      int tempSum = 0;
      for (int cur = 0; cur < nums.length; cur ++) {
         tempSum += nums[cur];
         // 保存最大子数组和，否则就继续循环累加，此处只保存最大值
         if (tempSum > result) result = tempSum;
         // 如果当前数组和小于0，则重置为0，进入下一次for循环，不需要使用双指针遍历，双指针会超时！
         if (tempSum < 0) tempSum = 0;
      }
      return result;
   }

   public static void main(String[] args) {
      int[] nums = new int[]{-2, 0, -1};
      System.out.println(maxSubArray(nums));
   }
}
