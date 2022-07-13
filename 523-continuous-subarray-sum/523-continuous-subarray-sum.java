class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        int cumSum = 0;
        map.put(0,-1);
        
        for(int start = 0; start < n; start++){
            cumSum += nums[start];
            cumSum %= k;
            if(map.containsKey(cumSum)){
                if(start - map.get(cumSum) > 1) return true;
            }
            else{
                map.put(cumSum,start);
            }
        }
        
        return false;
    }
}