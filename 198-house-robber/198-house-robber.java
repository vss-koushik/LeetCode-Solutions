class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        dp[0] = nums[0];
        
        for(int i = 1; i < N; i++){
            int pick = nums[i];
            if(i > 1)
                pick += dp[i - 2];
            
            int notPick = nums[i - 1];
            if(i > 2)
                notPick += dp[i - 3];
            
            dp[i] = Math.max(pick, notPick);
        }
        
        return dp[N-1];
    }
}