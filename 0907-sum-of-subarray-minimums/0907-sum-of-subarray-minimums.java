import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        
        int[] leftSmallest = leftSmallest(arr);
        int[] rightSmallest = rightSmallest(arr);
        long ans = 0;
        
        // Contribution Technique
        for (int i = 0; i < arr.length; i++) {
            int lRange = i - leftSmallest[i];
            int rRange = rightSmallest[i] - i;
            long contri = (long) lRange * rRange * arr[i];
            ans = (ans + contri % MOD) % MOD;
        }
        
        return (int) ans;
    }
    
    // Finding left smallest
    private int[] leftSmallest(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            
            st.push(i);
        }
        return ans;
    }
    
    // Finding right smallest
    private int[] rightSmallest(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            
            if (st.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = st.peek();
            }
            
            st.push(i);
        }
        return ans;
    }
}
