class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        //int[] leftSum = new int[n];
        //int[] rightSum = new int[n];
        int leftSum = 0;
        int rightSum = 0;
        int sum = 0;
        //for(int i = 1; i < n; i++)
          //  leftSum[i] = nums[i - 1] + leftSum[i - 1];
        
        //for(int i = n - 2; i >= 0; i--)
          //  rightSum[i] = nums[i + 1] + rightSum[i + 1];
        for(int x : nums) sum += x;
        for(int i = 0; i < n; i++){
            rightSum = sum - leftSum - nums[i];
            if(leftSum == rightSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
}