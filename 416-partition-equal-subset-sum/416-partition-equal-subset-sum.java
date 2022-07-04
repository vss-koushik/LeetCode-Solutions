class Solution {
    public boolean canPartition(int[] nums) {
        // Set<Integer> set = new HashSet<Integer>();
        int n = nums.length;
        int sum = 0;
        for(int num : nums)
            sum += num;
        int[][] dp = new int[n][sum];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return helper(0,0,n,nums,0, dp);
    }
    
    private boolean helper(int ind, int sum, int n, int[] nums, int otherSum, int[][]dp){
        // if(set.contains(sum) == true) 
            // return true;
        if(dp[ind][sum] != -1) return dp[ind][sum] == 0 ? false : true;
        if(ind == n - 1){
        
            // if(set.contains(sum + nums[ind])){
                // System.out.println(sum + nums[ind]);
                // return true;
            // }
            // else {
                // set.add(sum + nums[ind]);
                // return false;
            if(sum == (otherSum + nums[ind]) || (sum + nums[ind]) == otherSum)
                return true;
            else
                return false;
            }
        
        
        boolean pick = helper(ind + 1, sum + nums[ind], n, nums, otherSum, dp);
        boolean notPick = helper(ind + 1, sum, n, nums, otherSum + nums[ind], dp);
        dp[ind][sum] = pick || notPick == true ? 1 : 0;
        return pick || notPick;
    }
}