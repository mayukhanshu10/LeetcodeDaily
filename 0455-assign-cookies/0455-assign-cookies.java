class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int cnt =0;
        Arrays.sort(g);
        Arrays.sort(s);

        int l=0,r=0;

        while(l<g.length && r<s.length){
            if(s[r]>=g[l]){
                cnt++;
                l++;
                r++;
            }else{
                r++;
            }
        }

        return cnt;
    }
}