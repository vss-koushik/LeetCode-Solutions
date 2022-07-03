class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        char alphabet = 'a';
        for(char ch : key.toCharArray()){
            if(ch == ' ') continue;
            if(map.containsKey(ch) == false){
                map.put(ch, alphabet++);
            }
        }
        
        // System.out.println(map);
        
        char[] charArr = message.toCharArray();
        for(int i = 0; i < charArr.length; i++){
            if(map.containsKey(charArr[i]))
                charArr[i] = map.get(charArr[i]);
        }
        String str = String.copyValueOf(charArr);
        return str;
    }
}