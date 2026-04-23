class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> groupedAnagrams = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            Map<Character, Integer> anagramMap = new HashMap<>();

            for (int j = 0; j < word.length(); j++) {
                Character c = word.charAt(j);
                int currentCount = anagramMap.getOrDefault(c, 0);
                anagramMap.put(c, currentCount + 1);
            }

            List<String> group = groupedAnagrams.getOrDefault(anagramMap, new ArrayList<>());
            group.add(word);
            groupedAnagrams.put(anagramMap, group);
        }
        
        return new ArrayList<>(groupedAnagrams.values());
    }
}
