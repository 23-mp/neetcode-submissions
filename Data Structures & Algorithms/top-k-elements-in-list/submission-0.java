class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }
        List<Integer> result = new ArrayList<>();
        for (int count = nums.length; count > 0 && result.size() < k; count--) {
            for (int num : buckets.get(count)) {
                if (result.size() < k) {
                    result.add(num);
                }
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }
        return arr; 
    }
}
