class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String word : strs) {
            int[] count = new int[26];
            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }
            String key = Arrays.toString(count);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(groups.values());
    
    }
}
