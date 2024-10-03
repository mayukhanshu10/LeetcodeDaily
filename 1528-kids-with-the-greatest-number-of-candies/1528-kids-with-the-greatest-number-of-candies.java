class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int maxCandy = Integer.MIN_VALUE;
        for(int i=0;i<candies.length;i++){
            maxCandy=Math.max(maxCandy,candies[i]);
        }

        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=maxCandy){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }

        return ans;

    }
}