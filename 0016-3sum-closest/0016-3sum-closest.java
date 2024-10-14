class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int currentClosest = Integer.MAX_VALUE;
        // Sort the array
        Arrays.sort(nums);
        
        // Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip the same elements to avoid duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1; // Left pointer
            int right = nums.length - 1; // Right pointer
            
            // Two-pointer approach
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (Math.abs(target-sum)<Math.abs(target-currentClosest)) {
                    // result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    currentClosest = sum;
                } else if (sum < target) {
                    left++; // We need a larger sum
                } else {
                    right--; // We need a smaller sum
                }
            }
        }
        
        return currentClosest;
    }
}