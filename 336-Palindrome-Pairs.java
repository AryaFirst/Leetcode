class Solution {
    class Trie{
        int end;
        Trie []child;
        List<Integer> more;
        Trie(){
            this.end=-1;
            child=new Trie[26];
            more=new LinkedList<>();
        }
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        Trie root=new Trie();
        for(int i=0; i<words.length;i++)
            addTrie(root,words[i],i);

        List<List<Integer>> res=new LinkedList<>();
        for(int i=0;i<words.length;i++)
            search(res, root, words, i);
        return res;
        
    }
    public void addTrie(Trie root, String word, int index){
        for(int i=word.length()-1;i>=0;i--){
            
            if(root.child[word.charAt(i)-'a']==null)
                root.child[word.charAt(i)-'a']=new Trie();
            if(isPalindrom(word, 0, i))
                root.more.add(index);
            root=root.child[word.charAt(i)-'a'];
        }
       root.more.add(index);
        root.end=index;
    }
    
    
    public void search(List<List<Integer>> res, Trie root, String [] words, int index){
        String word=words[index];
        Trie node=root;
        for(int i=0;i<word.length();i++){
         
            if(node.end>=0&&isPalindrom(word, i, word.length()-1))
                res.add(Arrays.asList(index,node.end));
             node=node.child[word.charAt(i)-'a'];
            if(node==null) return;
        }
        for(int j: node.more){
            if(j!=index)
            res.add(Arrays.asList(index,j));
        }
    }
    
    public boolean isPalindrom(String str, int i, int j){
        while(i<j)
            if(str.charAt(i++)!=str.charAt(j--))
                return false;
        return true;
    }
}
