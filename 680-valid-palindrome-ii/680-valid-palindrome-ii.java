class Solution {
    public boolean validPalindrome(String s) {
        int N = s.length();
        int i = 0;
        int j = N-1;
        int delCount = 0;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return ( checkPalindrome(s,i,j-1) || checkPalindrome(s,i+1,j) );
            }
            i++;
            j--;
        }
        
        return true;
        
    }
    
    private boolean checkPalindrome(String str,int left, int right){
                
        while(left < right){
            if(str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        
        return true;
    }
}