class Solution {
    //Tabular Format
    // public int rob(int[] nums) {
    //     int len = nums.length;
    //     int dp[] = new int[len+1];
    //     dp[0]= nums[0];
    //     int profit=0;
    //     for(int i=1;i<len;i++){
    //         int pick = nums[i];
    //         if(i>1){
    //             pick += dp[i-2];
    //         }
    //         int notPick=dp[i-1];
    //         dp[i]=Math.max(pick,notPick);
    //     }
    //     return dp[len-1];
    // }

    //Recursive Memoization
    public int rob(int[] nums) {
        int len = nums.length;
        int dp[] = new int[len];
        Arrays.fill(dp,-1);
        return findProfit(nums,dp,len-1);
    }

    private int findProfit(int arr[], int dp[], int idx){
        if(idx<0){
            return 0;
        }
        if(idx == 0){
            return arr[idx];
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }

        int pick = arr[idx]+findProfit(arr, dp,idx-2);
        int notPick = findProfit(arr, dp,idx-1);
        return dp[idx]= Math.max(pick,notPick);
    }
}