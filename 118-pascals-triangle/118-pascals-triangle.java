class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> out_list = new ArrayList<List<Integer>>(numRows);
        for(int i = 1; i <= numRows; i++){
            ArrayList<Integer> innerList = new ArrayList<Integer>(i);
    
            for(int j = 0; j < i; j++){
                if(j == 0 || j == i - 1)
                    innerList.add(1);
                else{
                    int sum = out_list.get(i-2).get(j-1) + out_list.get(i-2).get(j);
                    innerList.add(sum);
                }
            }
            out_list.add(new ArrayList<Integer>(innerList));
        }
        return out_list;
    }
}