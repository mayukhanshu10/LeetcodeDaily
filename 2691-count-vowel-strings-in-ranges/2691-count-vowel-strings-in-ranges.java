class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int len = queries.length;
        int ans[]=new int[len];
        int prefix[] = new int[words.length];
        prefix[0] = isStringVowel(words[0]);

        for(int i =1;i<words.length;i++){
            prefix[i]=prefix[i-1]+isStringVowel(words[i]);
        }

        for(int i = 0; i<len; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if(start ==0){
                ans[i] = prefix[end];
            }else{
                ans[i]= prefix[end]-prefix[start-1];
            }
        }

        return ans;

    }


    private int isStringVowel(String s){
        if(s.charAt(0)=='a' || s.charAt(0)=='e' || s.charAt(0)=='i' ||s.charAt(0)=='o' ||s.charAt(0)=='u'){
            if(s.charAt(s.length()-1)=='a' ||s.charAt(s.length()-1)=='e' ||s.charAt(s.length()-1)=='i' ||s.charAt(s.length()-1)=='o' ||s.charAt(s.length()-1)=='u'){
                return 1;
            }
        }
        return 0;
    }
}