class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] delta = new int[n + 1]; // Difference array with an extra space for bounds
        
        // Populate the difference array based on shifts
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            
            if (direction == 1) { // Forward shift
                delta[start] += 1;
                delta[end + 1] -= 1;
            } else { // Backward shift
                delta[start] -= 1;
                delta[end + 1] += 1;
            }
        }
        
        // Compute cumulative shifts
        int currentShift = 0;
        for (int i = 0; i < n; i++) {
            currentShift += delta[i];
            delta[i] = currentShift; // Store the cumulative shift directly in delta
        }
        
        // Apply the shifts to the string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char original = s.charAt(i);
            int shift = delta[i] % 26; // Modulo 26 to handle large shifts
            if (shift < 0) { // Handle negative shifts by wrapping around
                shift += 26;
            }
            char shifted = (char) ((original - 'a' + shift) % 26 + 'a');
            result.append(shifted);
        }
        
        return result.toString();
    }
}