class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        
        int [][] cnt=new int [maze.length][maze[0].length];
        for(int []row:cnt)
        Arrays.fill(row,Integer.MAX_VALUE);
        cnt[start[0]][start[1]]=0;
       dfs(cnt, maze, start);
         return cnt[destination[0]][destination[1]]!=Integer.MAX_VALUE?cnt[destination[0]][destination[1]]:-1;
    }
    
    public void dfs(int [][]cnt, int [][]maze, int []cur){
       int [][] directions={{-1,0},{1,0},{0,-1},{0,1}};
           
            int r=cur[0];
            int c=cur[1];
            
            for(int []dir:directions){
                int count=0;
                int rnew=r+dir[0];
                int cnew=c+dir[1];
                while(rnew>=0&&rnew<maze.length&&cnew>=0&&cnew<maze[0].length&&maze[rnew][cnew]==0){
                        rnew+=dir[0];
                        cnew+=dir[1];
                    count++;
                
                
                }
                rnew-=dir[0];
                cnew-=dir[1];
                if(cnt[r][c]+count<cnt[rnew][cnew])
                {
                    cnt[rnew][cnew]=cnt[r][c]+count;
                    dfs(cnt,maze, new int []{rnew,cnew});
                }
            }
        }
       
    }
