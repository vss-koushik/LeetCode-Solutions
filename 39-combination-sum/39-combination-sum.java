class Solution {
    private List<List<Integer>> out_list = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<Integer>();
        helper(candidates, target, 0, 0, list);
        return out_list;
    }
    
    private void helper(int[] arr, int target, int index, int sum, List<Integer> list){
        if(index > arr.length-1) return;
        
        if(sum == target){
            out_list.add(new ArrayList<Integer>(list));
            return;
        }
        
        if(sum > target) return;
        
        list.add(arr[index]);
        sum += arr[index];
        helper(arr, target, index, sum, list);
        
        sum -= list.get(list.size()-1);
        list.remove(list.size() - 1);
        helper(arr, target, index+1, sum, list);
    }
}