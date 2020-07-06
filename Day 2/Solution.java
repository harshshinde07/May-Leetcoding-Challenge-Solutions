 // [2 May] Jewels and Stones

class Solution {
    public int numJewelsInStones(String J, String S) {
    
        int jewelCount = 0;
        char[] stones = S.toCharArray();
        
        for(char i: stones) {
            if(J.contains(Character.toString(i))) {
                jewelCount++;
            }
        }
        return jewelCount;
    }
}