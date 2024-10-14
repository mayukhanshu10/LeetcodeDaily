import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
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
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Move the left pointer to the right and skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Move the right pointer to the left and skip duplicates
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // We need a larger sum
                } else {
                    right--; // We need a smaller sum
                }
            }
        }
        
        return result;
    }
}
