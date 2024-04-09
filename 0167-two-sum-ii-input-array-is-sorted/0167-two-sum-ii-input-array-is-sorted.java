class Solution {
    public int[] twoSum(int[] arr, int target) {
        int i=0,j=arr.length-1;
        int start =-1,end=-1;
        while(i<j){
            int sum =arr[i]+arr[j];
            if(sum==target){
                start = i+1;
                end=j+1;
                break;
            }else if(sum>target){
                j--;
            }else{
                i++;
            }
        }
        return new int[]{start,end};
        
    }
}