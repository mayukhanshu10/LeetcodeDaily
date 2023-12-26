class Solution {
    public double myPow(double x, int n) {
        double ans =1;
        long pow =n;
        if(n<0){
            x=1/x;
            pow = Math.abs((long)n);
        }
        
        while(pow>0){
            if(pow%2==1){
                ans=ans*x;
                pow-=1;
            }else{
                x=x*x;
                pow=pow/2;
            }
        }
        return ans;
    }
}