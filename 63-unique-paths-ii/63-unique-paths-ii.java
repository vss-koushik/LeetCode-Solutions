class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        if(obstacleGrid[m-1][n-1] == 1  || obstacleGrid[0][0] == 1) return 0;
        return helper(0,0,m,n,obstacleGrid, dp);
    }
    
    private int helper(int i, int j, int m, int n, int[][] obstacles, int[][] dp){
        if(i == m-1 && j == n - 1)
            return 1;
        if(obstacles[i][j] == 1)
            return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int right = 0;
        int down = 0;
        if(j < n-1)
            right = helper(i,j+1,m,n,obstacles,dp);
        if(i < m-1)
            down = helper(i+1,j,m,n,obstacles,dp);
        dp[i][j] = right + down;
        return right + down;
    }
}