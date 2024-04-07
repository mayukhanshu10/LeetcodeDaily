class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length){
            return -1;
        }
        //Lets find max day from array
        int maxDay =-1;
        int minDay = -1;
        for(int i : bloomDay){
            maxDay = Math.max(maxDay,i);
            minDay = Math.min(minDay,i);
        }
        int ans=-1;
        int l=minDay,h=maxDay;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(isDay(bloomDay,m,k,mid)){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    
    
    private boolean isDay (int[] arr,int m, int k,int day){
        int countOfBo = 0;
        int countTillNow =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
                countTillNow+=1;
            }else{
                int cal = countTillNow/k;
                countOfBo += cal;
                countTillNow=0;
            }
        }
        countOfBo+=countTillNow/k;
        return (countOfBo>=m);
    }
}