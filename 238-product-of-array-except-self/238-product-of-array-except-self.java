class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] out_arr = new int[n];
        int[] leftProd = new int[n];
        leftProd[0] = 1;
        out_arr[n-1] = 1;
        
        for(int i = 1; i < n; i++){
            leftProd[i] = leftProd[i - 1] * nums[i - 1];
        }
        
        for(int i = n - 2; i >= 0; i--){
            out_arr[i] = out_arr[i + 1] * nums[i + 1];
        }
        for(int i = 0; i < n; i++){
            out_arr[i] = out_arr[i] * leftProd[i];
        }
        return out_arr;
    }
}