class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 1) return 1;
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            if(set.contains(num) == false)
                set.add(num);
        }
        int count = 0;
        int maxCount = 0;
        for(int num : nums){
            if(set.contains(num - 1) == false){
                int temp = num;
                count = 1;
                maxCount = Math.max(maxCount, count);
                while(set.contains(temp + 1)){
                    count++;
                    maxCount = Math.max(maxCount, count);
                    temp++;
                }
            }
            else count = 0;
        }
        
        return maxCount;
    }
}