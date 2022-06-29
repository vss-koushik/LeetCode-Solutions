class Solution {
    public boolean isSubsequence(String s, String t) {
        // Two pointers approach
        int s1 = s.length();
        int t1 = t.length();
        if(s1 > t1) return false;
        if(s == "") return true;
        int j = 0;
        for(int i = 0; i < s1; i++, j++){
            if(j >= t1) return false;
            if(s.charAt(i) != t.charAt(j)){
                while(j < t1 && s.charAt(i) != t.charAt(j))
                    j++;
            }
            if(j >= t1) return false;
        }
        
        return true;
    }
}