class Solution {
    public int[] asteroidCollision(int[] nums) {
        
        
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) { // Positive asteroid
                st.push(nums[i]);
            } else { // Negative asteroid
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(nums[i])) {
                    st.pop(); // Destroy the positive asteroid
                }
                if (!st.isEmpty() && st.peek() == Math.abs(nums[i])) {
                    st.pop(); // Both asteroids are destroyed
                } else if (st.isEmpty() || st.peek() < 0) {
                    st.push(nums[i]); // Negative asteroid survives
                }
            }
        }
        int n = st.size();
        if(n==0){
            return new int[]{};
        }
        int ans[] = new int[n];
        for(int i = n-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}