package leetcode.stack;
//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
//
//
//
// 示例 1:
//
//
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
//
//
// 示例 2:
//
//
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
//
//
// 示例 3:
//
//
//输入: temperatures = [30,60,90]
//输出: [1,1,0]
//
//
//
// 提示：
//
//
// 1 <= temperatures.length <= 10⁵
// 30 <= temperatures[i] <= 100
//
//
// Related Topics 栈 数组 单调栈 👍 1772 👎 0

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author duxiaopeng
 * @Date 2024/6/20 20:56
 * @Description 739-每日温度
 */
public class LC_739_DailyTemperatures {
   public int[] dailyTemperatures(int[] temperatures) {
      int[] result = new int[temperatures.length];
      // 单调栈  Deque
      Deque<Integer> stack = new LinkedList<>();

      for (int i = 0; i < temperatures.length; i++) {

         if (stack.isEmpty()) {
            stack.push(i);
         } else {
            // while循环：当前遍历到的温度 可能是栈中好几个温度的 右侧第一个大值
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
               Integer lastIndex = stack.pop();
               result[lastIndex] = i - lastIndex;
            }
            stack.push(i);
         }
      }
      return result;
   }

   public static void main(String[] args) {
      LC_739_DailyTemperatures lc739DailyTemperatures = new LC_739_DailyTemperatures();
      int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
      System.out.println(Arrays.toString(lc739DailyTemperatures.dailyTemperatures(temperatures)));
   }
}
