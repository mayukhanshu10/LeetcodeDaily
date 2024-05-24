class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int[] leftSmallest = leftSmallest(heights);
        int[] rightSmallest = rightSmallest(heights);
        int n = heights.length;
        int area = -1;
        for(int i=0;i<n;i++){
            int h = heights[i];
            int w = rightSmallest[i]-leftSmallest[i]-1;
            area = Math.max(area,h*w);
        }
        
        return area;
    }
    
    
    
    //Finding left Smallest
    private int[] leftSmallest(int[] nums){
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int ans[] = new int[n];
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                ans[i]=-1;
            }else{
                ans[i]=st.peek();
            }
            
            st.push(i);
        }
        return ans;
    }
    
    
    //Finding right Smallest
    private int[] rightSmallest(int[] nums){
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int ans[] = new int[n];
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                ans[i]=n;
            }else{
                ans[i]=st.peek();
            }
            
            st.push(i);
        }
        return ans;
    }
}