//bfs
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //initialize
        Queue<int []> queue =new LinkedList<>();
        queue.add(new int []{start[0],start[1]});
        boolean [][]visited=new boolean [maze.length][maze[0].length];
        visited[start[0]][start[1]]=true;
        int [][]directions={{-1,0},{1,0},{0,1},{0,-1}};
        
        while(queue.size()!=0){
            int [] pos=queue.poll();
             if(destination[0]==pos[0]&&destination[1]==pos[1])
                   return true;
                   
            for(int [] direction:directions){
                int r=pos[0]+direction[0];
                int c=pos[1]+direction[1];
                while(r>=0&&c>=0&&r<maze.length&&c<maze[0].length&&maze[r][c]==0)
                {  r+=direction[0];
                    c+=direction[1];
                }
               
                   if(!visited[r-direction[0]][c-direction[1]])
                   {r-=direction[0];
                    c-=direction[1];
                   
                queue.add(new int []{r,c});
                visited[r][c]=true;
                   }
            }
            
        }
        return false;
    }
}
