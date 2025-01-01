class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int totalOnes = 0;
        
        // Count the total number of ones in the string
        for (char c : s.toCharArray()) {
            if (c == '1') {
                totalOnes++;
            }
        }
        
        int maxScore = 0;
        int leftZeros = 0;
        int rightOnes = totalOnes;
        
        // Iterate and calculate the score at each possible split
        for (int i = 0; i < n - 1; i++) { // Ensure left and right are non-empty
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }
            
            // Calculate the score
            int score = leftZeros + rightOnes;
            maxScore = Math.max(maxScore, score);
        }
        
        return maxScore;
    }
}