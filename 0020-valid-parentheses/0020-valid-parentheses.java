class Solution {
    public boolean isValid(String s) {
        
        
        boolean flag = false;
        Stack<Character> st = new Stack<>();
        
        
        for(int i =0 ; i<s.length();i++){
            if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(' ){
                flag = true;
                st.push(s.charAt(i));
            }else{
                if(st.size()>0){ // Might throw null pointer exception if doesnt put this check
                    char x = st.peek(); 
                    if(s.charAt(i)==')'){
                        if(x=='('){
                            st.pop();
                        }else{
                            return false;
                        }
                    }else if(s.charAt(i)=='}'){
                        if(x=='{'){
                            st.pop();
                        }else{
                            return false;
                        }
                    }else if(s.charAt(i)==']'){
                        if(x=='['){
                            st.pop();
                        }else{
                            return false;
                        }
                    }
                }else{return false;}
            }
        }
        if(st.isEmpty() && flag == true){
                return true;
            }
            return false;
        
        
    }
}