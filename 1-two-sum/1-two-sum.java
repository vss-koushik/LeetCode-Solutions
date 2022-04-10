class Solution {
    public int[] twoSum(int[] nums, int target) {
        int N = nums.length;
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < N; i++){
            if(map.containsKey(target - nums[i])){
                result[0] = i;
                result[1]= map.get(target - nums[i]);
            }
            else
               map.put(nums[i], i);
        }
        return result;
    }
}
               
               