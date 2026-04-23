class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedAnagrams = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            int[] anagramCount = new int[26];

            for (char c : word.toCharArray()) {
                anagramCount[c - 'a']++;
            }

            String key = Arrays.toString(anagramCount);
            groupedAnagrams.putIfAbsent(key, new ArrayList<>());
            groupedAnagrams.get(key).add(word);
        }

        return new ArrayList<>(groupedAnagrams.values());
    }
}
