class Solution {
    public int[] sortArrayByParity(int[] A) {
        int lastEvenIndex = 0;
        for (int i=0; i< A.length; i++) {
            if (A[i] % 2 == 0) {
                int tmp = A[lastEvenIndex];
                A[lastEvenIndex] = A[i];
                A[i] = tmp;
                lastEvenIndex++ ;
            }
        }  
        return A;
    }
}