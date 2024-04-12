class Solution {
    public int longestOnes(int[] nums, int k) {
        int cnt =0;
        int i =0, j=0, len=0, maxLen=0;
        
        while(j<nums.length){
            if(nums[j]==0){
                cnt++;
            }
            
            while(cnt>k){
                if(nums[i]==0){
                    cnt--;
                }
                i++;
            }
            
            maxLen=Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}