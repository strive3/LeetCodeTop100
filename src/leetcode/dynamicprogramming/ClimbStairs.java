package leetcode.dynamicprogramming;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * 提示：
 *
 * 1 <= n <= 45
 * Related Topics
 * 记忆化搜索
 * 数学
 * 动态规划
 */
public class ClimbStairs {

    /**
     * 思路：最后一节 楼梯 一定是 2或者1 也就是等于 （n-2） + （n-1）
     * 第一节楼梯 1种方法
     * 第二节楼梯 2种方法
     * 第三节楼梯 3种方法
     * 第四节楼梯 5种方法
     * 第5节楼梯  一定是 爬上第3节楼梯的方式 + 爬上第4节楼梯的方式 也就是8种方法
     * 方式 1：递归，缺点超出时间限制
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs1(n-2) + climbStairs1(n - 1);
    }

    /**
     * 动态规划，利用历史记录，避免重复计算
     * 1.使用数据来存储历史数据（数组的定义，dp[i] 代表 多少种爬楼梯的方式）
     * 2.找出递推关系式 例如 dp[i] = dp[i-1] + dp[i-2]
     * 3.找出初始值
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int[] arr = new int[n];
        // 找出初始值
        if (n == 1) {
            arr[0] = 1;
        }
        if (n == 2) {
            arr[1] = 2;
        }
        if (n > 2) {
            // 初始值
            arr[0] = 1;
            arr[1] = 2;
            for (int i = 2; i < n; i++) {
                // 递推公式
                arr[i] = arr[i - 1] + arr[i - 2];
            }
        }
        return arr[n - 1];
    }
}
