class Solution {
    public int minimumLength(String s) {
        int[] charFrequency = new int[26];
        int totalLength = 0;

        // Count frequency of each character
        for (char currentChar : s.toCharArray()) {
            charFrequency[currentChar - 'a']++;
        }

        // Calculate the minimum length based on frequency
        for (int frequency : charFrequency) {
            if (frequency == 0) continue;
            if (frequency % 2 == 0) {
                totalLength += 2;
            } else {
                totalLength += 1;
            }
        }

        return totalLength;
    }
}