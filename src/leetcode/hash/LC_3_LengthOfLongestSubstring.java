package leetcode.hash;
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 10⁴
// s 由英文字母、数字、符号和空格组成
//
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10183 👎 0

import java.util.HashSet;

/**
 * @Author duxiaopeng
 * @Date 2024/6/18 20:19
 * @Description 3-无重复字符的最长子串
 */
public class LC_3_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        //长度为1，直接返回
        if (s.length() == 1) {
            return 1;
        }
        HashSet<Character> chars = new HashSet<Character>();
        char[] charArray = s.toCharArray();
        int result = 0;
        for (int i = 0; i < charArray.length; i++) {
            chars.add(charArray[i]);
            for (int j = i + 1; j < charArray.length; j++) {
                if (!chars.contains(charArray[j])) {
                    chars.add(charArray[j]);
                } else {
                    // 发现相同元素，则酸楚最大值，并且清空hash表
                    result = Math.max(result, chars.size());
                    chars.clear();
                    break;
                }
            }
            // j循环完成之后，仍然没有重复的，需要算一下最大值
            result = Math.max(result, chars.size());
        }
        return result;
    }

    public static void main(String[] args) {
        LC_3_LengthOfLongestSubstring lc3LengthOfLongestSubstring = new LC_3_LengthOfLongestSubstring();
        System.out.println(lc3LengthOfLongestSubstring.lengthOfLongestSubstring("au"));
    }
}
