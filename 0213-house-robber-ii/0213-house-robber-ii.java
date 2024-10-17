class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len==1){
            return nums[0];
        }
        int dp[] = new int[len];
        Arrays.fill(dp,-1);
         int dp2[] = new int[len];
        Arrays.fill(dp2,-1);
        //Case 1 Pick last and end 2nd
        int prof1 = findProfit(nums,dp,len-1,1);
        //Case 2 Pick 2nd last and end 1st
        int prof2 = findProfit(nums,dp2,len-2,0);

        return Math.max(prof1,prof2);
    }

    private int findProfit(int arr[], int dp[], int idx,int end){
        if(idx<end){
            return 0;
        }
        
        if(dp[idx]!=-1){
            return dp[idx];
        }

        int pick = arr[idx]+findProfit(arr, dp,idx-2,end);
        int notPick = findProfit(arr, dp,idx-1,end);
        return dp[idx]= Math.max(pick,notPick);
    }
}