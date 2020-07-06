// [18 May] Permutation in String

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s2 == null || s2.length() == 0) {
            return s2.equals(s1);
        }
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2map = new int[26];
            // iterator every possible substring of s2 of the same length of s1
            for (int j = 0; j < s1.length(); j++) {
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1map, s2map))
                return true;
        }

        return false;
    }

    boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i]) {
                return false;
            }
        }
        return true;
    }
}