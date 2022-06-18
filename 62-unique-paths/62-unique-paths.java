class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row,0);
        for(int i = m - 1; i>= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 && j == n - 1) dp[i][j] = 1;
                else {
                if(i < m -1)
                    dp[i][j] += dp[i + 1][j];
                if(j < n - 1)
                    dp[i][j] += dp[i][j + 1];
               }
            }
        }
        
        return dp[0][0];
    }
    /* Memoization Solution
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
    }*/
}