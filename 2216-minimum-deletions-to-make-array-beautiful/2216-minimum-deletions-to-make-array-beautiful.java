class Solution {
    public int minDeletion(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int num : nums)
            list.add(num);
        boolean var = (100000 == 100000);
        //System.out.println(var);
        //int N = nums.length;
        int deletions = 0;
       // int flag = 0;
        int i = 0;
        
        while(i < list.size()-1){
                //System.out.println("Entered Loop");
                //System.out.println("i is "+i);
                //System.out.println("Value of list[i] is "+list.get(i));
                //System.out.println("Value of list[i+1] is "+ list.get(i+1));
                //System.out.println(list.get(i) == list.get(i+1));
                if(list.get(i).equals(list.get(i+1))){
                    list.remove(i+1);
                    deletions++;
                    i -= 2;
                }
            i+=2;
        }
        
        if(list.size()%2 == 1)
            deletions++;
        
        return deletions;
    }
        
}