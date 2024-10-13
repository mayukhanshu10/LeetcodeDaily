public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();  // Length of each word
        int totalWords = words.length;
        int totalLen = wordLen * totalWords;  // Total length of concatenated words

        if (s.length() < totalLen) {
            return result;  // If the string `s` is shorter than the combined length of words, no valid substring exists
        }

        // Step 1: Create a frequency map of words
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Loop over the string with word-length shifts
        for (int i = 0; i < wordLen; i++) {
            // Sliding window over the string `s` with step `wordLen`
            int left = i;
            int right = i;
            int count = 0;  // Number of valid words found in the current window
            Map<String, Integer> windowMap = new HashMap<>();

            while (right + wordLen <= s.length()) {
                // Extract a word from the current position
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                // If the word is in our target word list, process it
                if (wordCountMap.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    // If the count of a word exceeds its desired count, shift the window
                    while (windowMap.get(word) > wordCountMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // If all words are matched, store the start index of the window
                    if (count == totalWords) {
                        result.add(left);
                    }
                } else {
                    // If the word is not in `words`, reset the window
                    windowMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}