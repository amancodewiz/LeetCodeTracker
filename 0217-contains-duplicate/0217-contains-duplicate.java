class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set =new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}

// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         Set<Integer> numSet=new HashSet<>();
//         for(int n:nums){
//             if(numSet.contains(n)){
//                 return true;
//             }
//             numSet.add(n);
//         }
//         return false;
//     }
// }