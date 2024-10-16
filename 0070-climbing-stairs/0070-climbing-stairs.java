class Solution {
    // public int climbStairs(int n) {
    //     //Tabular (From base to N)
    //     int dp[] = new int[n+1];
    //     dp[0]=1;
    //     dp[1]=1;
    //     for(int i=2;i<=n;i++){
    //         dp[i]=dp[i-1]+dp[i-2];
    //     }

    //     return dp[n];
    // }

    public int climbStairs(int n) {
        //Tabular (From base to N)
        // Space Optamization
        int prevToPrev =1;
        int prev =1;
        int curr=0;
        for(int i=2;i<=n;i++){
            curr = prev+prevToPrev;
            prevToPrev=prev;
            prev=curr;
        }
        return prev;
    }
}