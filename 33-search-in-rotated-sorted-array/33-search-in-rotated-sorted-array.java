class Solution {
    public int search(int[] nums, int target) {
                int low = 0;
                int high = 1;
                int res = -1;
                int n = nums.length;
                if(n == 1){
                    if(nums[0] == target)
                        return 0;
                    else
                        return -1;
                }
                while(nums[low] <= nums[high]){
                  if(high == n-1 && nums[low] < nums[high]){
                    res = binarySearch(nums, 0, n-1, target);
                    return res;
                    }
                    low++;
                    high++;
                }
                
                if(high == n-1 && nums[low] < nums[high]){
                    if(high == 1){
                        if(target == nums[1])
                            return 1;
                        else if(target == nums[0])
                            return 0;
                        else
                            return -1;
                    }
                    res = binarySearch(nums, 0, n-1, target);
                    return res;
                }
                res = binarySearch(nums,0,high-1, target);
                if(res != -1)
                      return res;

                low = high;
                high = n-1;
                res = binarySearch(nums, low, high, target);
            
                //if(res != -1)
                  //    res = low - 1 + res;
                return res;
    }
              
    private int binarySearch(int[] nums, int left, int right, int target){
        int pivot = 0;
        while(left <= right){
            pivot = left + (right - left)/2;
            if(nums[pivot] == target) return pivot;
            if(nums[pivot] < target) left = pivot + 1;
            else 
                right = pivot - 1;
        }
        return -1;
    }
}
    
    
    
    