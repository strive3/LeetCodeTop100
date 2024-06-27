package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 503. 下一个更大元素 II
 * 中等
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 *
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 */
/**
 * @Author du-xp
 * @Date 2024/6/27
 * @return: null
 * @Description 503-下一个更大的元素II
 * 思路2:可以使用取模运算 来减少代码量
 */
public class LC_503_NextGreaterElements {


    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        // 单调栈 栈顶到栈底 递增
        Deque<Integer> stack = new ArrayDeque<>();

        // 先循环一次 找数组右边第一个比自身大的元素
        for (int i = 0; i < nums.length; i++) {
            result[i] = -1;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                Integer lowIndex = stack.pop();
                result[lowIndex] = nums[i];
            }
            // 仅仅第一次循环进行push，将所有元素进行压栈，两次循环来在循环数组中右边第一个大数字
            stack.push(i);
        }
        // 第二次循环，由于是循环数组，不再对单调栈进行push，仅仅寻找第一次循环没有找到右边第一个大数字的元素
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                Integer lowIndex = stack.pop();
                result[lowIndex] = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC_503_NextGreaterElements lc503NextGreaterElements = new LC_503_NextGreaterElements();
        System.out.println(Arrays.toString(lc503NextGreaterElements.nextGreaterElements(new int[]{1,2,1})));
    }

}
