import java.util.HashMap;
import java.util.HashSet;

//Method-1 Brute Force
/*
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency of each number
        for (int num : arr) {
            //map.put(num, map.getOrDefault(num, 0) + 1);
            //OR using containsKey
            if (map.containsKey(num)) {
                // already present → increment old value
                map.put(num, map.get(num) + 1);
            } else {
                // not present → first occurrence
                map.put(num, 1);
            }
        }

        // Step 2: Store all frequencies in a HashSet
        HashSet<Integer> set = new HashSet<>();
        for (int freq : map.values()) {
            set.add(freq);
        }

        // Step 3: If sizes match, all frequencies were unique
        return map.size() == set.size();
    }
}
 */
//===============================================================
//Method-2 Optimised Solution using constraints [-1000 <= arr[i] <= 1000]=>We will add these two into one, so it will become 2001 
/*How it Works
int[] freq = new int[2001];
→ Index 0 corresponds to value -1000, index 2000 corresponds to +1000.

freq[x + 1000]++
→ Shifts all values by +1000 to avoid negative indices.

Collect only non-zero frequencies into a list, sort them.

If any two consecutive frequencies are equal → not unique → return false.

Otherwise return true. */

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Step 1: Frequency array of size 2001 (to cover -1000 to +1000)
        int[] freq = new int[2001];  

        // Step 2: Count occurrences (shift index by +1000 to handle negatives)
        for (int x : arr) {
            freq[x + 1000]++;
        }

        // Step 3: Convert freq[] to a list for sorting
        List<Integer> list = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) list.add(f);  // only keep positive frequencies
        }

        // Step 4: Sort the list
        Collections.sort(list);

        // Step 5: Check for duplicate frequencies
        for (int i = 1; i < list.size(); i++) {
            if (Objects.equals(list.get(i), list.get(i - 1))) {
                return false;
            }
        }

        return true;
    }
}
