class Solution {
    public int waysToSplitArray(int[] nums) {
        int len = nums.length;

        // Calculate total sum of the array
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Iterate and calculate valid splits
        long leftSum = 0;
        int count = 0;
        for (int i = 0; i < len - 1; i++) { // Ensure at least one element on the right
            leftSum += nums[i];
            long rightSum = totalSum - leftSum;
            if (leftSum >= rightSum) {
                count++;
            }
        }
        return count;
    }
}
