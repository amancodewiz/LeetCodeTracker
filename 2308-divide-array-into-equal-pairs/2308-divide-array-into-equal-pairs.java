class Solution {
    public boolean divideArray(int[] nums) {
        // 1. Create a HashMap to store the frequency of each number.
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // 2. Count how many times each number appears in 'nums'.
        for (int x : nums) {
            frequencyMap.put(x, frequencyMap.getOrDefault(x, 0) + 1);
        }
        
        // 3. Check if every number occurs an even number of times.
        //    If any frequency is odd, we cannot pair up all instances of that number.
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return false;
            }
        }
        
        // 4. If all frequencies are even, return true.
        return true;
    }
}
