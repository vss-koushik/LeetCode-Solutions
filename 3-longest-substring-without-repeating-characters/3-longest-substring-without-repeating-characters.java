class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        
        Set<Character> set = new HashSet<Character>();
        int max = 0;
        while(right < n){
            char ch = s.charAt(right);
            
            if(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            
            else{
                set.add(ch);
                right++;
            }
            max = Math.max(max, set.size());
        }
        
        return max;
    }
}