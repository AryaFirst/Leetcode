//dfs

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,LinkedList<Integer>> map=new HashMap<>();
        for(int []pre:prerequisites){
            if(map.containsKey(pre[0])==false)
                map.put(pre[0],new LinkedList<Integer>());
            map.get(pre[0]).add(pre[1]);
        }
        List<Integer> ordered=new LinkedList<>();
        Set<Integer>  visited=new HashSet<>();
        for(int i=0;i<numCourses;i++){
            if(!visited.contains(i)&&!dfs(ordered,visited,map,i))
                return new int[0];
        }
        int [] res=new int [numCourses];
        int index=0;
        while(ordered.size()!=0)
        {
            res[index++]=ordered.get(0);
            ordered.remove(0);
        }
            return res;
    }
    public boolean dfs(List<Integer> ordered, Set<Integer> visited, Map<Integer,LinkedList<Integer>> map,int i){
        if(ordered.contains(i)) return true;
        if(visited.contains(i)) return false;
        visited.add(i);
        if(map.containsKey(i)){
        for(int inte:map.get(i)){
            if(!dfs(ordered,visited,map,inte))
                return false;
        }
        }
        ordered.add(i);
        return true;
    }
}


//bfs
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,LinkedList<Integer>> map=new HashMap<>();
        int []res=new int[numCourses];
        int []cnt=new int[numCourses];
        for(int i=0;i<numCourses;i++)
            map.put(i,new LinkedList<>());
        for(int []pre:prerequisites){
            map.get(pre[1]).add(pre[0]);
            cnt[pre[0]]++;
        }
        Queue<Integer> visited=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(cnt[i]==0)
                visited.add(i);
        }
        int index=0;
        while(visited.size()!=0){
            int cur=visited.peek();
            res[index++]=cur;
            visited.poll();
            for(int i:map.get(cur))
            {cnt[i]--;if(cnt[i]==0) visited.add(i);}
        }
            
        return (index==numCourses)?res:new int[0];
    }
}
