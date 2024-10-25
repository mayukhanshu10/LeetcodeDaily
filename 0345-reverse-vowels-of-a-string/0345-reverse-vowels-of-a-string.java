class Solution {
    public String reverseVowels(String s) {
        // Convert the string to a character array for easy modification
        char[] chars = s.toCharArray();
        
        // Define the vowels for quick reference
        String vowels = "aeiouAEIOU";
        
        int left = 0;
        int right = chars.length - 1;
        
        // Use two pointers to find and swap vowels
        while (left < right) {
            // Move left pointer forward until it finds a vowel
            while (left < right && vowels.indexOf(chars[left]) == -1) {
                left++;
            }
            // Move right pointer backward until it finds a vowel
            while (left < right && vowels.indexOf(chars[right]) == -1) {
                right--;
            }
            
            // Swap the vowels at the left and right pointers
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            // Move both pointers towards the center
            left++;
            right--;
        }
        
        // Convert the character array back to a string
        return new String(chars);
    }
}
