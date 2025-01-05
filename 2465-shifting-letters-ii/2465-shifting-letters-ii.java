/*

https://leetcode.com/problems/shifting-letters-ii/solutions/6231675/prefix-sum-detailed-explaition-by-sumeet-iak7

*/


class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
       int n = s.length();
        int[] shift = new int[n + 1]; // Difference array to track shifts

        // Step 1: Populate the difference array
        for (int[] shiftOp : shifts) {
            int start = shiftOp[0], end = shiftOp[1], direction = shiftOp[2];
            int value = (direction == 1 ? 1 : -1); // Determine shift direction
            shift[start] += value; // Apply shift to the start index
            if (end + 1 < n) shift[end + 1] -= value; // Undo shift after end index
        }

        // Step 2: Calculate cumulative shifts
        int currentShift = 0;
        for (int i = 0; i < n; i++) {
            currentShift += shift[i];
            shift[i] = currentShift; // Store cumulative shift directly
        }

        // Step 3: Apply shifts to the string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int netShift = (shift[i] % 26 + 26) % 26; // Normalize shift within [0, 25]
            char shiftedChar = (char) ((s.charAt(i) - 'a' + netShift) % 26 + 'a'); // Apply shift
            result.append(shiftedChar); // Append shifted character
        }

        return result.toString(); // Return final result
    }
}