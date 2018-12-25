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
