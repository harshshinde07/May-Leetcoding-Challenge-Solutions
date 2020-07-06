// [17 May] Find All Anagrams in a String

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();

        if (s == null || s.length() == 0 || s.length() < p.length()) return result;

        int[] counts = new int[26];
        for(char c : p.toCharArray()) counts[c - 'a']++;

        int left = 0;
        int right = 0;
        int count = p.length();

        while(right < s.length()) {
            if(counts[s.charAt(right++) - 'a']-- >= 1) count--;

            if(count == 0) result.add(left);

            if(right - left == p.length() && counts[s.charAt(left++) - 'a']++ >= 0) count++;
        }
        return result;
    }
}