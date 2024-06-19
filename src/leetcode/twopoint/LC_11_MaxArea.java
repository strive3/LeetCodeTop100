package leetcode.twopoint;
//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 返回容器可以储存的最大水量。
//
// 说明：你不能倾斜容器。
//
//
//
// 示例 1：
//
//
//
//
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
// 示例 2：
//
//
//输入：height = [1,1]
//输出：1
//
//
//
//
// 提示：
//
//
// n == height.length
// 2 <= n <= 10⁵
// 0 <= height[i] <= 10⁴
//
//
// Related Topics 贪心 数组 双指针 👍 5009 👎 0
/**
 * @Author duxiaopeng
 * @Date 2024/6/19 20:29
 * @Description 11-盛水最多的容器
 */
public class LC_11_MaxArea {

    public int maxArea(int[] height) {
        int result = 0;
        // 左指针
        int left = 0;
        // 右指针
        int right = height.length - 1;

        while (left < right) {
            // 左指针高度
            int leftHigh = height[left];
            // 右指针高度
            int rightHigh = height[right];

            // 盛水高度，取两个边的最小值
            int high = Math.min(leftHigh, rightHigh);
            // 盛水宽度
            int width = right - left;

            // 计算盛水区域
            result = Math.max(Math.multiplyExact(high, width), result);

            // 如果左高度 小于 右高度， 挪动左指针，否则挪动右指针。

            // 如果我们保持左指针的位置不变，那么无论右指针在哪里，这个容器的容量都不会超过 leftHigh * width
            // 同理 右指针位置不变，无论左指针在哪里，这个容器的容量都不会超过 leftHigh * width
            // 因此 哪边高度小，移动哪边

            // *****装多少水是由最短边决定的，为什么最短边移动，是因为如果长边移动，那么装的水可能会少，（因为由最短边决定，无论你长边移动后高度增加或者减少，都只能是装水量变少。）不可能会多。而如果移动最短边，那么有可能能够装更多的水。
            if (leftHigh < rightHigh) {
                left ++;
            } else {
                right --;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,3,2,5,25,24,5};

        LC_11_MaxArea lc11MaxArea = new LC_11_MaxArea();
        System.out.println(lc11MaxArea.maxArea(height));
    }
}
