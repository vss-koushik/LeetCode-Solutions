class Solution {
    //private int count = 1;
    public boolean isPowerOfTwo(int n) {
        if(n==0)
            return false;
        if(n==1)
            return true;
        if(n%2 == 1)
            return false;
        if(n == 2)
            return true;
        //count = count*2;
        return isPowerOfTwo(n/2);
    }
}