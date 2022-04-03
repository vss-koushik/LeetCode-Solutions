class Solution {
    public void nextPermutation(int[] nums){
        int N = nums.length;
        int i = N-2;
        
        while(i >= 0 && nums[i] >= nums[i+1])
            i--;
        
        if(i >= 0){
            int j = N - 1;
            while(nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        
        reverse(nums, i + 1);
    }
    
    private void swap (int[] nums, int i , int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start){
        int end = nums.length - 1;
        while(start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    
}
/*
 123, 132, 213, 231, 312, 321
 
 
 12345678
 13245678
 13246578
 13246758
 13246785
*/