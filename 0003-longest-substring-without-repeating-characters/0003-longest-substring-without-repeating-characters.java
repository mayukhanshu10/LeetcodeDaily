class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans =0;
        int len=0;
        HashSet<Character> hs = new HashSet<>();
        int i=0,j=0;
        
       while(j<s.length()){
           char c = s.charAt(j);
           if(!hs.contains(c)){
               hs.add(c);
               len++;
               ans=Math.max(len,ans);
               j++;
           }else{
               hs.remove(s.charAt(i));
               i++;
               len--;
           }
       }
        return ans;
    }
}