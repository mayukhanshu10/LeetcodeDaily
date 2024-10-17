class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int dp[] = new int[len+1];
        dp[0]= nums[0];
        int profit=0;
        for(int i=1;i<len;i++){
            int pick = nums[i];
            if(i>1){
                pick += dp[i-2];
            }
            int notPick=dp[i-1];
            dp[i]=Math.max(pick,notPick);
        }
        return dp[len-1];
    }
}