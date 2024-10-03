class Solution {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();

        StringBuilder str = new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                str.append(s.charAt(i));
            }else{
                if (str.length() > 0) { // Check if str is not empty
                    list.add(str.toString()); // Add the current word to the list
                    str.setLength(0); // Reset StringBuilder for the next word
                }
            }
        }
        // Add the last word if there is one
        if (str.length() > 0) {
            list.add(str.toString());
        }

        StringBuilder result = new StringBuilder();
        // Reverse the words by iterating from the end of the list
        for (int i = list.size() - 1; i >= 0; i--) {
            result.append(list.get(i));
            if (i > 0) {
                result.append(" "); // Add space between words
            }
        }
        return result.toString(); // Convert to string and return
    }
}