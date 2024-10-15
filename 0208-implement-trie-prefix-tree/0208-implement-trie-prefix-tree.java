class Node{
    char data;
    Node[] child;
    boolean isEnd;

    Node(){
        child = new Node[26];
        isEnd=false;
    }

    Node(char c){
        this.data=c;
        child = new Node[26];
        isEnd=false;
    }
}
class Trie {
    Node root;
    public Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        int len=word.length();
        Node curr = root;
        for(int i=0;i<len;i++){
            int idx = word.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx]=new Node(word.charAt(i));
            }
            curr=curr.child[idx];
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word) {
        int len=word.length();
        Node curr = root;
        for(int i=0;i<len;i++){
            int idx = word.charAt(i)-'a';
            if(curr.child[idx]==null){
                return false;
            }
            curr=curr.child[idx];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        Node curr = root;
        for(int i=0;i<len;i++){
            int idx = prefix.charAt(i)-'a';
            if(curr.child[idx]==null){
                return false;
            }
            curr=curr.child[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */