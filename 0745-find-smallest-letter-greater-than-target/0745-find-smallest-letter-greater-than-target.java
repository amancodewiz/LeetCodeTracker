class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        char ans = '#'; // Default when no greater element is found

        // Binary Search loop
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] > target) {
                // Candidate for next greatest letter
                ans = letters[mid];
                // But maybe a smaller valid candidate exists on the left
                high = mid - 1;
            } else {
                // If letters[mid] <= target, we need to search right half
                low = mid + 1;
            }
        }

        // If ans is still '#', that means no element > target was found
        // Depending on problem statement:
        // (1) If array is circular -> return letters[0]
        // (2) Else return '#' or any special indicator
        if (ans == '#') {
            return letters[0]; // circular array version (LeetCode style)
        }

        return ans; // smallest letter greater than target
    }
}    