class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        // Arrays to track characters on the left and right of current index
        int[] left = new int[26];
        int[] right = new int[26];

        // Populate right array with the frequency of each character
        for (char c : s.toCharArray()) {
            right[c - 'a']++;
        }

        // Set to store unique palindromes
        Set<String> uniquePalindromes = new HashSet<>();

        // Iterate through the string
        for (int j = 0; j < n; j++) {
            char middleChar = s.charAt(j);
            right[middleChar - 'a']--; // Current char is no longer in "right"

            // Check for palindromic subsequences
            for (int i = 0; i < 26; i++) {
                if (left[i] > 0 && right[i] > 0) {
                    // Form a palindrome with left and right characters
                    String palindrome = "" + (char) ('a' + i) + middleChar + (char) ('a' + i);
                    uniquePalindromes.add(palindrome);
                }
            }

            // Add current char to "left"
            left[middleChar - 'a']++;
        }

        // Return the number of unique palindromes
        return uniquePalindromes.size();
    }
}