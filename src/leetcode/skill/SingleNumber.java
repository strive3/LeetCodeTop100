package leetcode.skill;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 136.只出现一次的数字
 *
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * 示例 1 ：
 *
 * 输入：nums = [2,2,1]
 * 输出：1
 * 示例 2 ：
 *
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 * 示例 3 ：
 *
 * 输入：nums = [1]
 * 输出：1
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * 除了某个元素只出现一次以外，其余每个元素均出现两次。
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], nums[i]);
            }
        }
        return new ArrayList<Integer>(map.values()).get(0);
    }

    /**
     * 异或元素
     *
     * 1.任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a
     * 2.任何数和其自身做异或运算，结果是 0，即 a⊕a=0
     * 3.异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     *
     * 因此 若有2n+1个数，同时有n个数出现了2两次，一个数出现了一次，则总体的异或结果就为 单独出现的数字
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }


}
