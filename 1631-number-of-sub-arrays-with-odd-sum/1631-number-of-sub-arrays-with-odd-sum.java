class Solution {
    public int numOfSubarrays(int[] arr) {
        int curSum = 0; 
        int oddCnt = 0, evenCnt = 0; 
        int res = 0;
        int MOD = 1_000_000_007; // 10^9 + 7 (to handle large numbers)
        
        for (int n : arr) {
            curSum += n; // Update the cumulative sum
            
            if (curSum % 2 != 0) { // If the cumulative sum is odd
                res = (res + 1 + evenCnt) % MOD; // Include all subarrays ending at current index with an odd sum
                oddCnt++; // Increase odd count
            } else { // If the cumulative sum is even
                res = (res + oddCnt) % MOD; // Include all subarrays ending at current index with an even sum
                evenCnt++; // Increase even count
            }
        }
        return res;
    }
}
