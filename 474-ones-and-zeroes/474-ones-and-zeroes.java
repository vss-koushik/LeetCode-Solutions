class Solution {
    Integer[][][] dp;
    public int largestSubset(String[] strs, int idx , int m , int n){
        if(m < 0 || n < 0) return -1;
        if(idx == strs.length) return 0;
        if(dp[idx][m][n] != null) return dp[idx][m][n];
        int currZeroes = 0, currOnes = 0;
        for(int i = 0 ; i < strs[idx].length(); i++){
            if(strs[idx].charAt(i) == '1')
                currOnes++;
        }
        currZeroes = strs[idx].length() - currOnes;
        int pick = 1 + largestSubset(strs, idx + 1 , m - currZeroes, n - currOnes);
        int unpick = largestSubset(strs, idx + 1, m , n);
        return dp[idx][m][n] = Math.max(pick,unpick);
    }
    
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new Integer[strs.length+1][m+1][n+1];
        return largestSubset(strs, 0 , m , n);    
    }
}