// [1 May] Ransom Note

import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
    
        HashMap<Character, Integer> ransomMap = new HashMap<>();
        HashMap<Character, Integer> magzineMap = new HashMap<>();
        
        char[] ransomArr = ransomNote.toCharArray();
        char[] magzineArr = magazine.toCharArray();
        
        for(char r: ransomArr) {
            if(ransomMap.containsKey(r)) {
                ransomMap.put(r, ransomMap.get(r) + 1);
            } else {
                ransomMap.put(r, 1);
            }
        }
        
        for(char m: magzineArr) {
            if(magzineMap.containsKey(m)) {
                magzineMap.put(m, magzineMap.get(m) + 1);
            } else {
                magzineMap.put(m, 1);
            }
        }
        
        for (Map.Entry<Character, Integer> entry : ransomMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            
            if(magzineMap.containsKey(key)) {
                int val = magzineMap.get(key);
                if(val < value) {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return true;
        
    }
}