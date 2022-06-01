class Solution {
    public int[] runningSum(int[] nums) {
        int sum = nums[0];
        int numsLen = nums.length;
        for(int index = 1; index < numsLen; index++){
            //int numIndex = nums[index]
            sum += nums[index];
            nums[index] = sum;
        }
        
        return nums;
    }
}