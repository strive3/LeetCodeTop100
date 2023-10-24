package leetcode.greedyalgorithm;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 提示：
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 * Related Topics
 * 数组
 * 贪心算法：在遍历向前推进时，找到一个最小买入价格minprice，然后，在没有找到下一个更小的买入价格时，计算接下来每一天的利润，记录其中最大利润。
 * 如果找到下一个最小买入价格minprice，继续计算接下来未找到下一个更小买入价格时的利润最大值，直到遍历完prices数组，maxProfit就是历史最大差值！
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        // 贪心算法：
        // 存储结果值
        int maxProfit = 0;
        // 数组最小值的下标
        int minprice = 0;
        // 只有第2天才可以开始卖出，所以 i 为 2
        for (int i = 1; i < prices.length; i++) {
            // 找出最小的价格（元素）
            if (prices[i] < prices[minprice]) {
                minprice = i;
            } else {
                // 求出差值，也就是最大利润
                maxProfit = Math.max(maxProfit, prices[i] - prices[minprice]);
            }
        }
        return maxProfit;
    }
}
