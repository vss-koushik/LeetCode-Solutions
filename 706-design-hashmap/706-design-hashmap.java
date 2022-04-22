class MyHashMap {
    private List<Entry>[] arr = new List[16];
    int size = 0;

    public MyHashMap() {
        for (int i = 0; i < arr.length; i++)
            arr[i] = new LinkedList<>();
    }

    public void put(int key, int val) {
        if (size < arr.length * 0.75) {
            List<Entry> tmp = arr[key % arr.length];

            Entry entry = find(key, tmp);
            if (entry == null)
                tmp.add(new Entry(key, val));
            else
                entry.val = val;
        } else {
            List<Entry>[] tmp = arr.clone();

            arr = new List[(int)Math.pow(tmp.length, 2)];
            for (int i = 0; i < arr.length; i++)
                arr[i] = new LinkedList<>();

            for (List<Entry> list : tmp) {
                for (Entry item : list) {
                    if (item != null)
                        arr[item.key%arr.length].add(item);
                }

            }

            arr[key%arr.length].add(new Entry(key, val));
        }

        size++;
    }

    public int get(int key) {
        //System.out.println("key=" + key + " idx=" + (key%arr.length) + " " + Arrays.toString(this.arr));
        List<Entry> tmp = arr[key%arr.length];
        if (tmp == null) return -1;

        Entry entry = find(key, tmp);

        return entry == null ? -1 : entry.val;
    }

    private Entry find(int key, List<Entry> tmp) {
        Iterator<Entry> iterator = tmp.iterator();
        while (iterator.hasNext()) {
            Entry e = iterator.next();
            if (e.key == key) return e;
        }
        
        return null;
    }

    public void remove(int key) {
        List<Entry> list = arr[key%arr.length];
        Iterator<Entry> iterator = list.listIterator();

        while (iterator.hasNext()) {
            Entry next = iterator.next();
            if (next.key == key) {
                iterator.remove();
                size--;
                break;
            }
        }
    }
}

class Entry {
    public Entry(int key, int val) {
        this.key = key;
        this.val = val;
    }
    
    int key;
    int val;
    
    public String toString() {
        return "{key="+key+"; val="+val+"}";
    }
}







/*class MyHashMap {
    private final static int size = 10000;
    class Node{
        int key;
        int val;
        Node next;
        
        Node(int key, int val){
            this.val = val;
            this.key = key;
        }
    }
    
    Node[] map;
    
    private int hash(int key){
        return key % size;
    }
    public MyHashMap() {
        map = new Node[size];
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        Node curr = map[index];
        if(curr == null){
            map[index] = new Node(key,value);
            return;
        }
        //Node prev = null;
        if(curr.key == key){
            curr.val = value;
            return;
        }
        while(curr.next != null){
            if(curr.key == key){
                curr.val = value;
                return;
            }
            
            curr = curr.next;
        }
        
        curr.next = new Node(key,value);        
    }
    
    public int get(int key) {
        int index = hash(key);
        Node curr = map[index];
        if(curr == null)
            return -1;
        while(curr != null){
            if(curr.key == key)
                return curr.val;
        }
        
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node curr = map[index];
        if(curr == null)
            return;
        if(curr.key == key){
            map[index] = null;
            return;
        }
        Node prev = curr;
        curr = curr.next;
        while(curr != null){
            prev = prev.next;
            System.out.println("Value of prev is : "+prev.key);
            curr = curr.next;
            if(curr.key == key){
                prev.next = curr.next;
                curr.next = null;
                return;
            }
        }
    }
}
*/

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */