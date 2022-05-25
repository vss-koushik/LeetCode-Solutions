class Solution {
    public int rob(int[] nums) {
        if(nums == null)
            return 0;
        if(nums.length == 1)
            return nums[0];
        return Math.max(rob(nums,1,nums.length-1), rob(nums,0,nums.length-2));
    }
    private int rob(int[] nums, int begin, int end) {
        int N = nums.length;
        int[] dp = new int[N];
        dp[begin] = nums[begin];
        
        for(int i = begin+1; i < end+1; i++){
            if(i == 0)continue;
            int pick = nums[i];
            if(i > 1)
                pick += dp[i - 2];
            
            int notPick = nums[i - 1];
            if(i > 2)
                notPick += dp[i - 3];
            
            dp[i] = Math.max(pick, notPick);
        }
        
        return dp[end];
    }
}