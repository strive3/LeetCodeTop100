package leetcode.stack;
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 1 <= n <= 2 * 10⁴
// 0 <= height[i] <= 10⁵
//
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 5195 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author duxiaopeng
 * @Date 2024/6/20 20:28
 * @Description 42-接雨水
 */
public class LC_42_Trap {


    public int trap(int[] height) {

        int result = 0;
        // 声明单调栈
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);

        // 按列计算
        for (int i = 1; i < height.length; i ++) {

            if (height[stack.peek()] > height[i]) { // 因为单调栈，要找数组右边大的元素，因此这里直接push
                stack.push(i);
            } else if (height[stack.peek()] == height[i]) { // 如果两个元素相等，则计算容量一定是以右边元素为边，因此此处可以先pop 再push
                // 因为相等的相邻墙，左边一个是不可能存放雨水的，所以pop左边的index, push当前的index
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    // 每次循环弹出一个  底值（中间值）  --------3个元素才可以计算出容量
                    Integer midHigh = height[stack.pop()];
                    if (!stack.isEmpty()) {
                        // 左边第一个大值
                        Integer leftIndex = stack.peek();
                        Integer leftHigh = height[leftIndex];
                        // 当前元素为右边第一个大值
                        Integer rightHigh = height[i];
                        // 取两边小值 作为 高
                        Integer minHigh = Math.min(leftHigh, rightHigh);
                        // 高 * 宽
                        result += (minHigh - midHigh) * (i - leftIndex - 1);
                    }
                }
                stack.push(i);
            }
        }
        return result;
    }

    /**
     * @Author du-xp
     * @Date 2024/6/25
     * @param height:
     * @return: int
     * @Description 对trap 代码进行简化
     */
    public int trap2(int[] height) {

        int result = 0;
        // 声明单调栈
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);

        // 按列计算
        for (int i = 1; i < height.length; i ++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                // 每次循环弹出一个  底值（中间值）  --------3个元素才可以计算出容量
                // 相等元素  其实也可以都push 进去， 因为 相同元素的mid 和left 相等，高为0，因此计算结果不会有变动
                Integer midHigh = height[stack.pop()];
                if (!stack.isEmpty()) {
                    // 左边第一个大值
                    Integer leftIndex = stack.peek();
                    Integer leftHigh = height[leftIndex];
                    // 当前元素为右边第一个大值
                    Integer rightHigh = height[i];
                    // 取两边小值 作为 高
                    Integer minHigh = Math.min(leftHigh, rightHigh);
                    // 高 * 宽
                    result += (minHigh - midHigh) * (i - leftIndex - 1);
                }
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        LC_42_Trap lc42Trap = new LC_42_Trap();
        System.out.println(lc42Trap.trap2(new int[]{4,3,3,5}));
    }
}
