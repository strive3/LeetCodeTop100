package leetcode.stack;
//nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
//
// 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
//
// 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定
//nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
//
// 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出：[-1,3,-1]
//解释：nums1 中每个值的下一个更大元素如下所述：
//- 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
//- 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
//- 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
//
// 示例 2：
//
//
//输入：nums1 = [2,4], nums2 = [1,2,3,4].
//输出：[3,-1]
//解释：nums1 中每个值的下一个更大元素如下所述：
//- 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
//- 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
//
//
//
//
// 提示：
//
//
// 1 <= nums1.length <= nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 10⁴
// nums1和nums2中所有整数 互不相同
// nums1 中的所有整数同样出现在 nums2 中
//
//
//
//
// 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
//
// Related Topics 栈 数组 哈希表 单调栈 👍 1180 👎 0

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author duxiaopeng
 * @Date 2024/6/26 21:31
 * @Description 496-下一个更大元素I
 */
public class LC_496_NextGreaterElement {

   public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      int[] result = new int[nums1.length];
      // 存放 num2 的 元素，下标  方便找见开始遍历的下标
      Map<Integer, Integer> map = new HashMap<>();
      Deque<Integer> stack = new LinkedList<>();

      for (int i = 0; i < nums2.length; i++) {
         map.put(nums2[i], i);
      }

      for (int i = 0; i < nums1.length; i++) {
         result[i] = -1;
         if (map.containsKey(nums1[i])) {
            // 将当前元素 push到栈中
            stack.push(nums1[i]);
            for (int k = map.get(nums1[i]); k < nums2.length; k++) {
               // 当前元素比栈顶元素大，说明已经找到右边第一个大元素
               if (!stack.isEmpty() && stack.peek() < nums2[k]) {
                  stack.pop();
                  result[i] = nums2[k];
                  break;
               }
            }
            // 如果右边元素 没有大的，需要对栈进行 清空
            stack.clear();
         }
      }
      return result;
   }


   /**
    * @Author du-xp
    * @Date 2024/6/26
    * @param nums1:
    * @param nums2:
    * @return: int[]
    * @Description TODO
    */
   public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
      int[] result = new int[nums1.length];
      // key：  nums2 元素   value：右边第一个大的元素
      Map<Integer, Integer> map = new HashMap<>();

      Deque<Integer> stack = new ArrayDeque<>();

      // 寻找每个元素的 右边最大元素
      for (int i = 0; i < nums2.length; i++) {

         while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
            Integer benchMarkIndex = stack.pop();
            int benchMarkValue = nums2[benchMarkIndex];

            map.put(benchMarkValue, nums2[i]);
         }
         stack.push(i);
      }

      // 由于nums1 是 nums2的子集，因此只用从nums2中找出nums1对应的数据就行
      for (int i = 0; i < nums1.length; i++) {
         result[i] = map.get(nums1[i]) == null ? -1 : map.get(nums1[i]);
      }

      return result;
   }

   public static void main(String[] args) {
      LC_496_NextGreaterElement lc496NextGreaterElement = new LC_496_NextGreaterElement();
      int[] nums1 = new int[]{1,4,3};
      int[] nums2 = new int[]{1,3,2,4};
      System.out.println(Arrays.toString(lc496NextGreaterElement.nextGreaterElement2(nums1, nums2)));;
   }
}
