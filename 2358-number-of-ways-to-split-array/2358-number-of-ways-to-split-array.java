/*
Key Observations:
1) Avoid Redundant Work: Instead of calculating the sum of the right part (rightSum) 
from scratch for each index, you can derive it dynamically:
        rightSum=totalSum−leftSum
This avoids iterating over the array repeatedly.

2)Dynamic Calculation: By maintaining a running sum for the left part (leftSum),
you can directly compare it to the dynamically computed rightSum for each index.

3) Use Total Sum: The total sum of the array remains constant and acts as the baseline 
to derive rightSum as the complement of leftSum.

4) Iterate Up to len - 1: Since the split must leave at least one element in the right part, 
you iterate only until len - 1.
*/

// class Solution {
//     public int waysToSplitArray(int[] nums) {
//         int len = nums.length;

//         // Calculate total sum of the array
//         long totalSum = 0;
//         for (int num : nums) {
//             totalSum += num;
//         }

//         // Iterate and calculate valid splits
//         long leftSum = 0;
//         int count = 0;
//         for (int i = 0; i < len - 1; i++) { // Ensure at least one element on the right
//             leftSum += nums[i];
//             long rightSum = totalSum - leftSum;
//             if (leftSum >= rightSum) {
//                 count++;
//             }
//         }
//         return count;
//     }
// }


class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        
        // Compute the left prefix sum
        long[] leftSum = new long[n];
        leftSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i];
        }
        
        // Compute the right prefix sum
        long[] rightSum = new long[n];
        rightSum[n - 1] = 0; // No elements on the right of the last index
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }
        
        // Count valid splits
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (leftSum[i] >= rightSum[i]) {
                count++;
            }
        }
        
        return count;
    }
}

