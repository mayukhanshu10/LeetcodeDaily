/*
Prefix Sum for Preprocessing: We calculate a prefix sum array to store the cumulative
count of words that start and end with vowels, enabling efficient range queries.

Efficient Query Handling: Using the prefix array, we calculate the count of valid words 
for any range [li, ri] in constant time by subtracting prefix sums.

Vowel Check Optimization: The isStringVowel function determines if a word starts and ends 
with a vowel, ensuring correctness while minimizing redundancy.

Iterative Queries: For each query, the result is derived from the prefix array, 
avoiding redundant computations and ensuring scalability for large inputs.
*/


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