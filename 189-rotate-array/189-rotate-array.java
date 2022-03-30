class Solution {
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        k = k % N;
        reverseArray(nums, 0, N-1);
        //for(int i = 0; i < nums.length; i++)
          //  System.out.println(nums[i]);
        reverseArray(nums,0,k-1);
        reverseArray(nums,k,N-1);
    }
    
    private void reverseArray(int[] nums, int begin, int end){
        while(begin < end){
            //System.out.println("Begin - " + begin);
            //System.out.println("End - "+ end);
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}