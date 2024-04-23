package leetcode.hash;
//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
//
//
//
// 示例 1:
//
//
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
// 示例 2:
//
//
//输入: strs = [""]
//输出: [[""]]
//
//
// 示例 3:
//
//
//输入: strs = ["a"]
//输出: [["a"]]
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 10⁴
// 0 <= strs[i].length <= 100
// strs[i] 仅包含小写字母
//
//
// Related Topics 数组 哈希表 字符串 排序 👍 1876 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * @Author duxiaopeng
 * @Date 2024/4/23 23:42
 * @Description 49-字母异位词分组
 */
public class GroupAnagrams {

   public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<String, List<String>> map = new HashMap();
      for (int i = 0; i < strs.length; i ++) {
         // 拆分成 char数据，排序完成之后 再转变为string
         char[] charArray = strs[i].toCharArray();
         Arrays.sort(charArray);
         String sortString = new String(charArray);
         // 尝试获取，如果获取不到 返回新的ArrayList集合
         List<String> list = map.getOrDefault(sortString, new ArrayList<>());
         list.add(strs[i]);
         map.put(sortString, list);
      }

      return new ArrayList<List<String>>(map.values());
   }
}
