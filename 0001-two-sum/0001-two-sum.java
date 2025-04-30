//Brute Force
/*
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }
}
*/

//Using HashMap
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];

            if (map.containsKey(remaining)) {
                return new int[] { map.get(remaining), i };
            } else {
                map.put(nums[i], i);
            }

        }
        return new int[] {};
    }
}