class Solution {
    public int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i : nums){
            min = Math.min(min,i);
            max=Math.max(max,i-min);
        }
        if(max==0){
            return -1;
        }
        return max;
    }
}