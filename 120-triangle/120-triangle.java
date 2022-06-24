class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();
        int M = triangle.get(N-1).size();
        int[][] dp = new int[N][M];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return helper(0,0,triangle, triangle.size(), dp);
    }
    private int helper(int row, int last, List<List<Integer>> triangle, int N, int[][]dp){
        if(dp[row][last] != -1) return dp[row][last];
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        down = triangle.get(row).get(last);
        if(last < triangle.get(row).size() - 1)
            right = triangle.get(row).get(last+1);
        
        if(row == N - 1) return Math.min(down, right);
        
        down += helper(row + 1,last, triangle, N,dp);
        if(last < triangle.get(row).size() - 1)
            right += helper(row + 1, last + 1, triangle, N, dp);
        
        return dp[row][last] = Math.min(down, right);
    }
}