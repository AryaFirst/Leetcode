//###1 Union Find

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parents=new HashMap<>();
        Map<String, String> owners=new HashMap<>();
        Map<String, TreeSet<String>> mer=new HashMap<>();
        List<List<String>> ans=new LinkedList<>();
        
        for(List<String> acc:accounts){
            for(int i=1;i<acc.size();i++){
                parents.put(acc.get(i), acc.get(i));
                owners.put(acc.get(i), acc.get(0));
            } 
        }
        
        
        for(List<String> acc:accounts){
            for(int i=2;i<acc.size();i++){
                parents.put(find(acc.get(i),parents),find(acc.get(1),parents));
            }
        }
        
        for(List<String> acc:accounts){
             String parent=find(acc.get(1),parents);
                if(!mer.containsKey(parent))
                    mer.put(parent,new TreeSet<String>());
            
            for(int i=1;i<acc.size();i++){
              
                mer.get(parent).add(acc.get(i));
            }
        }
        
        
        for(String pp: mer.keySet()){
            List<String> tmp=new LinkedList<>(mer.get(pp));
            tmp.add(0,owners.get(tmp.get(0)));
            ans.add(tmp);
            
        }
        return ans;
    }
    public String find(String target, Map<String, String> map){
        return map.get(target)==target?target:find(map.get(target),map);
    }
    
}


//###2 DFS
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,String> names=new HashMap<>();
        for(List<String> acc:accounts){
            for(int i=1;i<acc.size();i++)
                names.put(acc.get(i),acc.get(0));
        }
        Map<String,HashSet<String>> graph=new HashMap<>();
        for(List<String>acc:accounts){
            for(int i=1;i<acc.size();i++){
                if(!graph.containsKey(acc.get(i)))
                    graph.put(acc.get(i),new HashSet<>());
                if(i==1) continue;
                graph.get(acc.get(i)).add(acc.get(i-1));
                graph.get(acc.get(i-1)).add(acc.get(i));
            }
        }
        
        Set<String> emails=new HashSet<>();
        List<List<String>>ls=new LinkedList<>();
        for(String email:names.keySet()){
            if(emails.add(email)){
                List<String> tmp= new LinkedList<>();
                dfs(graph,emails,email,tmp);
                Collections.sort(tmp);
                tmp.add(0,names.get(email));
                ls.add(tmp);
            }
        }
        return ls;
    }
    public void dfs(Map<String,HashSet<String>> graph, Set<String> emails, String email, List<String> tmp){
        tmp.add(email);
        for(String next: graph.get(email)){
            if(emails.add(next))
                dfs(graph,emails,next,tmp);
        }
    }
}
