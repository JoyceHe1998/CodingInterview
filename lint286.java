// Lintcode 386 · Longest Substring with At Most K Distinct Characters


public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s.length() == 0) return 0;
        int max_length = 1;
        if (k == 0) return 0;

        for (int i=0; i<s.length(); i++) {
            int j=i+1;

            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(i));

            if (j<s.length()) {
                set.add(s.charAt(j));
            }
            while (j<s.length() && set.size() <= k) {
                j++;
                if (j<s.length()) {
                    set.add(s.charAt(j));
                }
            }

            if (j == s.length()) {
                return Math.max(max_length, j-i);
            }

            max_length = Math.max(max_length, j-i);
        }
        return max_length;
    }
}