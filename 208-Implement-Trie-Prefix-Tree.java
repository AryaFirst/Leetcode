//
class Node{
       Node [] child=new Node[26];
       boolean finished;
      
       
       Node(){
           
       }
    
   }

class Trie {
    
    /** Initialize your data structure here. */
  
    
    Node root;
    public Trie() {
        this.root=new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node start=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(start.child[ch-'a']==null)
                start.child[ch-'a']=new Node();
            start=start.child[ch-'a'];
                
        }
        start.finished=true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
         Node start=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(start.child[ch-'a']==null)
                return false;
           else start=start.child[ch-'a'];
                
        }
        return start.finished;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
         Node start=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(start.child[ch-'a']==null)
                return false;
           else start=start.child[ch-'a'];
                
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
