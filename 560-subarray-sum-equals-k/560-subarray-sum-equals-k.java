public class Solution{
    public int subarraySum(int[] nums, int k){
        int count = 0;
        // Stores the cumulative sum and it's occurences
        HashMap<Integer, Integer> cumSumOccurences = new HashMap<>();
        cumSumOccurences.put(0,1);
        int len = nums.length;
        int cumSum = 0;
        for(int start = 0; start < len; start++){
            cumSum += nums[start];
            if(cumSumOccurences.containsKey(cumSum - k))
                count += cumSumOccurences.get(cumSum - k);
            cumSumOccurences.put(cumSum, cumSumOccurences.getOrDefault(cumSum,0) + 1);
        }
        return count;
    }
}

// O(n^2) Solution
/*public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}
*/