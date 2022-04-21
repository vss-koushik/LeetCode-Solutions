class MyHashSet {
    class Node{
        int val;
        Node next;
        
        Node(int data){
            this.val = data;
        }
    }
    
    private static final int size = 10000;
    
    private int hash(int key){
        return key % size;
    }
    
    
    Node[] set;
    
    
    public MyHashSet() {
        set = new Node[size];
    }
    
    public void add(int key) {
        int index = hash(key);
        Node curr = set[index];
        Node prev = null;
        if(curr == null){
            set[index] = new Node(key);
            return;
        }
        while(curr != null){
            prev = curr;
            if(curr.val == key)
                return;
            curr = curr.next;
        }
        prev.next = new Node(key);
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node curr = set[index];
        Node prev = null;
        if(curr == null)
            return;
        if(curr.val == key){
            set[index] = curr.next;
            return;
        }
        prev = curr;
        curr = curr.next;
        while(curr != null){
            //prev = curr;
            if(curr.val == key){
                prev.next = curr.next;
                curr.next = null;
                return;
            }
            prev = prev.next;
            curr = curr.next;
        }
        
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        Node curr = set[index];
        
        while(curr != null){
            if(curr.val == key)
                return true;
            curr = curr.next;
        }
        
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */