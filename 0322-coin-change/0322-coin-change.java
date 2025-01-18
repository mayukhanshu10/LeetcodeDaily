class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int dp[][] = new int[coins.length][amount+1];
        for(int[] x: dp){
            Arrays.fill(x,-1);
        }
        int result = findMinCoins(coins, amount, coins.length - 1,dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int findMinCoins(int[] coins, int amount, int ind, int[][] dp) {
        //Base Case
        if(ind==0){
            if(amount%coins[ind]==0){
                return dp[ind][amount]=amount/coins[ind];
            }else{
                return dp[ind][amount]=(int)Integer.MAX_VALUE;
            }
        }

        if(dp[ind][amount]!=-1){
            return dp[ind][amount];
        }

        //Not Pick
        int np = findMinCoins(coins,amount,ind-1,dp);

        //Pick
        int p = (int)Integer.MAX_VALUE;
        if(amount>=coins[ind]){
            int subResult = findMinCoins(coins, amount - coins[ind], ind,dp);
            if (subResult != Integer.MAX_VALUE) {
                p = 1 + subResult;
            }
        }

        return dp[ind][amount]=Math.min(np,p);
    }
}
