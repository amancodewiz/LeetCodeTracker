class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        // n is the original length of the colors array.
        int n = colors.length;
        // N is the length of the "extended" array.
        // We add (k-1) extra elements to handle the circular wrap-around.
        int N = n + (k - 1);

        // Create an extended array to simulate the circular array behavior.
        int[] extended = new int[N];
        // Copy the original colors array into the beginning of extended.
        System.arraycopy(colors, 0, extended, 0, n);
        // Append the first (k-1) elements to the end of the extended array.
        // This allows the window to "wrap around" the end back to the start.
        for (int i = 0; i < k - 1; i++) {
            extended[n + i] = colors[i];
        }

        // Initialize result to count the number of valid alternating groups.
        int result = 0;
        // Initialize two pointers: i is the start of the current window,
        // and j is used to traverse the array starting from index 1.
        int i = 0, j = 1;
        
        // Iterate while j is within the extended array.
        while (j < N) {
            // If the current element is equal to the previous element,
            // then the alternating sequence is broken.
            if (extended[j] == extended[j - 1]) {
                // Reset the start pointer i to the current position j,
                // because a new alternating group must start here.
                i = j;
                // Move j forward and continue to the next iteration.
                j++;
                continue;
            }

            // If the length of the current window (from i to j) equals k,
            // then we have found a valid alternating group.
            // Note: j - i + 1 is the length of the current window.
            if (j - i + 1 == k) {
                // Increment the count of valid alternating groups.
                result++;
                // Slide the window by moving the start pointer i by one.
                // This is part of the sliding window "Khandani Template" strategy.
                i++;
            }

            // Move j to expand the current window.
            j++;
        }

        // Return the total count of alternating groups of length k.
        return result;
    }
}
