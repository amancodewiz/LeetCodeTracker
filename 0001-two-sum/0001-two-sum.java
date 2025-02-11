class Solution {
    public int[] twoSum(int[] nums, int target) {
 int p=0,q=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    p=i;
                    q=j;
                }
            }
        }
        int res[]=new int[2];
        res[0]=p;
        res[1]=q;

        return res;
    }
}