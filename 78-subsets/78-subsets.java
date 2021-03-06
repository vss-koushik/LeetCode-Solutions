/*class Solution {
    private List<List<Integer>> out_list = new ArrayList<>();
    
    private void f(ArrayList<Integer> list, int[] nums, int index, int n){
        if(index == n){
            ArrayList<Integer> newList = new ArrayList<Integer>();
            //Collections.copy(newList, list);
            int list_size = list.size();
           // for(int i = 0; i < list_size; i++){
             //   newList.add(list.get(i));
            //}
            out_list.add(new ArrayList<Integer>(list));
           // if(list == out_list.get(out_list.size()-1))
             //   System.out.println("The List and OUT LIST HAVE SAME REFERENCES");
            return;
        }
        list.add(nums[index]);
        
        //System.out.println(index);
        //System.out.println(list);
        f(list,nums,index+1,n);
        //System.out.println(out_list);
        list.remove(list.size() - 1);
        f(list,nums,index+1,n);
    }
    public List<List<Integer>> subsets(int[] nums) {
        //System.out.println(nums.length);
        ArrayList<Integer> list = new ArrayList<Integer>();
        f(list,nums,0,nums.length);
        return out_list;
    }
    
} //f([1],nums,1,n)->f([1,2],nums,2)
*/
// Bit Manipulation Solution
class Solution {
    public boolean checkBit(int i, int j) {
        return (i>>j)%2!=0;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        for(int i = 0; i < (1<<nums.length); i++) {
            List<Integer> al = new ArrayList();
            for(int j = 0; j < nums.length;j++) {
                if(checkBit(i,j)) {
                    al.add(nums[j]);
                }
            }
            res.add(al);
        }
        return res;
    }
}