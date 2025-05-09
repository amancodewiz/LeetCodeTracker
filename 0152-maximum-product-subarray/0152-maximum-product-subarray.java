/*
class Solution {
    public int maxProduct(int[] nums) {
        int res=nums[0];
        int product=1;

        for(int n:nums){
            if(product<0){
              product=1;  
            }
            product*=n;
            res=Math.max(product,res);
        }
        return res;
    }
} */

//Brute Force
//Time Complexity
//O(n³) — because of three nested loops
/*
class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int product = 1;
                for (int k = i; k <= j; k++) {
                    product *= nums[k];
                }
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }
} */

//Time Complexity
//O(n2) — because of two nested loops
/*
class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {

                product = product * nums[j];
                maxProduct = Math.max(maxProduct, product);
            }

        }
        return maxProduct;
    }
} */

// Optimized- O(N): Striver's solution
class Solution {

    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }

            prefix = prefix * nums[i];
            suffix = suffix * nums[n - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
}