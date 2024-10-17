class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums){
            sum+=i;
        }
        if(sum%2==1){
            return false;
        }else{
            int target = sum/2;
            int dp[][] = new int[nums.length][target+1];
            for(int[] r : dp){
                Arrays.fill(r,-1);
            }
            return findSum(dp,nums,nums.length-1,target);
        }
    }

    private boolean findSum(int[][] dp, int arr[], int idx, int target){
        
        if(target==0){
            return true;
        }
        
        if(idx==0){
            return target==arr[idx];
        }
    
        
        if(dp[idx][target]!=-1){
            return dp[idx][target]==1;
        }
        
        boolean notPick = findSum(dp,arr,idx-1,target);
        
        //Pick element on this idx
        boolean pick=false;
        if(arr[idx]<=target){
            pick = findSum(dp,arr,idx-1,target-arr[idx]);
        }
        
        dp[idx][target] = (pick||notPick)?1:0;
        return (pick||notPick);
    }

}