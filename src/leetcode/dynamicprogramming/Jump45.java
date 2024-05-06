package leetcode.dynamicprogramming;
/*
给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

0 <= j <= nums[i]
i + j < n
返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。



示例 1:

输入: nums = [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
示例 2:

输入: nums = [2,3,0,1,4]
输出: 2


提示:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
题目保证可以到达 nums[n-1]
 */
/**
 * @Author duxiaopeng
 * @Date 2024/5/3 15:39
 * @Description 45-跳跃游戏 II
 */
public class Jump45 {
   public int jump(int[] nums) {
      // 若只有一个元素，那么不用跳跃就是数组的最后一个位置
      if (nums.length == 1) return 0;
      // 当前覆盖范围
      int cur = 0;
      // 下一步覆盖范围
      int next = 0;
      // 返回值：跳跃次数
      int step = 0;

      for (int i = 0; i < nums.length; i++) {
         // 更新下一步覆盖范围
         next = Math.max(next, i + nums[i]);
         // 如果当前覆盖范围已经到达了当前位置，就往后跳跃一次！！！注意从数组下标0开始，所以第一次进来要加1；只要数组元素大于1，那么step最少是1
         if (i == cur) {
            // 往后跳跃一次
            step ++;
            // 更新当前覆盖范围
            cur = next;
            // 如果当前覆盖范围已经覆盖数组的最后一个位置，就返回跳跃次数
            if (cur >= nums.length - 1) return step;
         }
      }

      return step;
   }
}
