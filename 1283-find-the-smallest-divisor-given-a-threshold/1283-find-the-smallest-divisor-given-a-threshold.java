class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        
        for(int i:nums){
            max=Math.max(i,max);
        }
        
        int l=1;
        int h = max;
        int ans=-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(findSum(nums,mid)<=threshold){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    
    private int findSum(int arr[],int mid){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            double val = (double)arr[i]/mid;
            sum+=Math.ceil(val);
        }
        return sum;
    }
}