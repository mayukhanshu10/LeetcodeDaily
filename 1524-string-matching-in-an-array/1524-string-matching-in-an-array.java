class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;

        List<String> list = new ArrayList<>();
        Arrays.sort(words);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && words[j].contains(words[i])){
                    list.add(words[i]);
                    break;
                }
            }
        }
        // Collections.sort(list); 
        return list;
    }
}