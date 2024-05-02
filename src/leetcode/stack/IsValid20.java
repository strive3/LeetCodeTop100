package leetcode.stack;
/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。


示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false
 */

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author duxiaopeng
 * @Date 2024/5/2 10:25
 * @Description 20-有效的括号
 */
public class IsValid20 {

    private static HashMap<Character, Character> map = new HashMap<>();
    static {
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
    }
    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();

        Stack<Character> stack = new Stack();
        for (Character c : charArray) {
            // 如果map中包含key，说明是反括号，需要判断栈中刚才进去的元素是不是它对应的正括号
            if (map.containsKey(c)) {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (!pop.equals(map.get(c)))
                    return false;
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "()";

        System.out.println(isValid(s));
    }
}
