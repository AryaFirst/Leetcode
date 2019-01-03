class Solution {
     List<String> res;
     Map<String, PriorityQueue<String>> map;
    public List<String> findItinerary(String[][] tickets) {
     res=new LinkedList<>();
     map=new HashMap<>();
        for(int i=0;i<tickets.length;i++)
        {
            if(!map.containsKey(tickets[i][0]))
                map.put(tickets[i][0],new PriorityQueue<String>());
            map.get(tickets[i][0]).add(tickets[i][1]);
        }
        
       
        dfs("JFK");
        
            
            
            
        return res;
    }
    public void dfs(String s){
        
        while(map.containsKey(s)&&map.get(s).size()!=0)
            dfs(map.get(s).poll());
        res.add(0,s);
    }
}
