package leetcode.dynamicprogramming;
//给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
//
// 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
//
// 返回一个表示每个字符串片段的长度的列表。
//
//
//示例 1：
//
//
//输入：s = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
//
// 示例 2：
//
//
//输入：s = "eccbbbbdec"
//
//输出：[10]
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 500
// s 仅由小写英文字母组成
//
//
// Related Topics 贪心 哈希表 双指针 字符串 👍 1133 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author duxiaopeng
 * @Date 2024/5/6 22:33
 * @Description 763-划分字母区间
 * 思路：最大下标
 */
public class PartitionLabels763 {
   public static List<Integer> partitionLabels(String s) {
      List<Integer> result = new ArrayList<>();

      char[] charArray = s.toCharArray();
      // 存储每个字母最后出现的位置
      HashMap<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < charArray.length; i++) {
         map.put(charArray[i], i);
      }
      // eccbbbbdecf
      // 8 9 9 6 6 6 6 7 8 9 10
      // 存储当前片段的结束位置 右区间下标
      Integer lastIndex = 0;
      // 存储当前片段的起始位置 左区间下标
      Integer prevIndex = 0;
      for (int i = 0; i < charArray.length; i++) {
         // 更新当前片段的结束位置，寻找当前片段的最大结束位置
         lastIndex = Math.max(map.get(charArray[i]), lastIndex);
         // 如果当前位置等于结束位置，说明找见分割线，当前片段结束，将结束位置加入结果集，并将当前位置设置为下一个片段的起始位置
         if (i == lastIndex) {
            result.add(lastIndex - prevIndex + 1);
            prevIndex = lastIndex + 1;
         }
      }
      return result;
   }

   public static void main(String[] args) {
      String s = "ababcbacadefegdehijhklij";
      System.out.println(partitionLabels(s));
   }
}
