class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Step 1: Preprocess words2 to find the maximum frequency of each character required
        int[] maxFreq = new int[26]; // For 'a' to 'z'
        for (String word : words2) {
            int[] freq = countFrequencies(word);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        // Step 2: Filter words1 to find universal words
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] freq = countFrequencies(word);
            if (isUniversal(freq, maxFreq)) {
                result.add(word);
            }
        }

        return result;
    }

    // Helper function to count character frequencies in a word
    private static int[] countFrequencies(String word) {
        int[] freq = new int[26]; // For 'a' to 'z'
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    // Helper function to check if a word meets the max frequency requirements
    private static boolean isUniversal(int[] freq, int[] maxFreq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] < maxFreq[i]) {
                return false;
            }
        }
        return true;
    }
}