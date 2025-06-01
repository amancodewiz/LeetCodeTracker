//Brute Force O(N3)
/*
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> st=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k]);
                        Collections.sort(temp); // Sorting to avoid duplicate sets in different order
                        st.add(temp); // Set ensures uniqueness
                    }
                }
            }
        }
        return new ArrayList<>(st);
    }
} */

//O(N2)
/*
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> st=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            Set<Integer> hashset=new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
               int third=-(nums[i]+nums[j]);

               if(hashset.contains(third)){
                 // We found a triplet!
                List<Integer> temp=Arrays.asList(nums[i],nums[j],third);
                Collections.sort(temp);
                st.add(temp);
               }
               hashset.add(nums[j]);
            }
        }
        return new ArrayList<>(st);
    }
} */


//Optimized(ONlogN)+O(N2)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);//sort the array->TC:O(NlogN)

        for(int i=0;i<nums.length;i++){
            // Skip duplicate values for i
            if(i>0 && nums[i]==nums[i-1]) continue; //pehle i=0 ko fix krdia in above for loop, uske baad check kia ki i apne previous i-1 ke barabar hai toh continue krdo which means for loop me jaakr i++ krdo; ye  krke hum duplicacy check kr rhe hai
           int j=i+1; //j=low
            int k=nums.length-1; //k=high

            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];

                //after this comes 3 Scenarios
                if(sum<0){
                   j++;     
                } else if(sum>0){
                k--;
                } else //triplet mil gya
                {
                    List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k]);
                    ans.add(temp);

                    j++;
                    k--;

                     // Skip duplicates for j and k
                     while(j<k && nums[j]==nums[j-1]) j++;
                     while(j<k && nums[k]==nums[k+1]) k--;

                }

            }
        }
        return ans;
    }
} 