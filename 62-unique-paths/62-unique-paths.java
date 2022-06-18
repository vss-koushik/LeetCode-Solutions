class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return helper(0,0,m,n,dp);
    }
    
    private int helper(int i, int j, int m, int n, int[][] dp){
        if(i == m-1 && j == n-1){
            return 1;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int right = 0;
        int down = 0;
        
        if(j < n-1)
            right = helper(i,j+1,m,n,dp);
        if(i < m - 1)
            down = helper(i + 1, j, m, n,dp);
        dp[i][j] = right + down;
        return right + down; 
    }
}