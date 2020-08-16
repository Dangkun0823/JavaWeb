package D3;

//7
public class DemoA {
    public int JumpFloor(int target) {
        int[] dp = new int[target + 1];   // 因为0台阶的存在,这里是target+1.
        dp[0] = 1;  // 到达0台阶的方法有一种 (就是不跳)
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
