class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length)
            return nums;
        
        HashMap<Integer, Integer> freq = new HashMap<Integer,Integer>();
        //Building hashmap to find how frequent each int occurs.. O(N) time
        for(int num : nums)
            freq.put(num, freq.getOrDefault(num,0) + 1);
        
        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap = new PriorityQueue<> ((n1,n2) -> freq.get(n1) - freq.get(n2));
        
        
        // keep k top frequent elements in the heap
        // takes O(Nlogk) time
        
        for(int n : freq.keySet()){
            heap.add(n);
            if(heap.size() > k)
                heap.poll();
        }
        
        
        // Building the output array
        
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; i--)
            top[i] = heap.poll();
        
        return top;
    }
}