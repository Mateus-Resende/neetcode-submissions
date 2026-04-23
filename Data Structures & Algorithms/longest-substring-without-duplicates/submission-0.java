class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        Set<Character> window = new HashSet<>();
        int maxLength = 0;

        for (int fast = 0; fast < s.length(); fast++) {
            while (window.contains(s.charAt(fast))) {
                window.remove(s.charAt(slow));
                slow++;
            }

            window.add(s.charAt(fast));

            maxLength = Math.max(maxLength, fast - slow + 1);
        } 

        return maxLength;
    }
}
