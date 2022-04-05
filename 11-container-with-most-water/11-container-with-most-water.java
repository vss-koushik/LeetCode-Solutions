class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        int currArea = 0;
        
        while(left < right){
            if(height[left] < height[right]){
                currArea = height[left] * (right - left);
                if(maxArea < currArea)
                    maxArea = currArea;
                left++;
            }
            else{
                currArea = height[right] * (right - left);
                if(maxArea < currArea)
                    maxArea = currArea;
                right--;
            }
        }
        
        return maxArea;
    }
}