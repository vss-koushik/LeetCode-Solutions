class Solution {
    List<String> ans = new ArrayList<>();
    Map<Character,char[]> m = new HashMap<>();
    public List<String> letterCombinations(String d) {
        if(d == null || d.equals(""))
            return ans;
        // Making a map of telephone buttons
        m.put('2',new char[] {'a','b','c'});
        m.put('3',new char[] {'d','e','f'});
        m.put('4',new char[] {'g','h','i'});
        m.put('5',new char[] {'j','k','l'});
        m.put('6',new char[] {'m','n','o'});
        m.put('7',new char[] {'p','q','r','s'});
        m.put('8',new char[] {'t','u','v'});
        m.put('9',new char[] {'w','x','y','z'});
        fun(d.toCharArray(),0,d.length(),new char[d.length()]);
        return ans;
    }
    void fun(char[] d,int i,int l,char[] a){
        if(i == l ){
            ans.add(String.valueOf(a,0,l));
            return;}
        for(int j = 0;j<m.get(d[i]).length;j++){ // for loop to get all characters from a perticular number button
            a[i] = m.get(d[i])[j]; // adding jth character from ith number button 
            fun(d,i+1,l,a); // invoking function for next number button (i+1)th
        }
    }
}