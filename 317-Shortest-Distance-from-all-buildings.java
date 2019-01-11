class Solution {
    public int shortestDistance(int[][] grid) {
        int building=0;
        int m=grid.length;
        int n=grid[0].length;
        int [][]total =new int [m][n];
        // building number
        int [][]reach=new int  [m][n];
        
        //BFS:
        int [][]directions={{0,1},{0,-1},{-1,0},{1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    building++;
                    boolean [][]visited=new boolean[m][n];
                    Queue<int []> queue=new LinkedList<>();
                    queue.add(new int []{i,j});
                    int cnt=1;
                    while(queue.size()!=0){
                        int q=queue.size();
                        
                    for(int l=0;l<q;l++){
                        int []cur=queue.poll();
                        int row=cur[0];
                        int col=cur[1];
                        for(int []dir:directions){
                            int new_row=row+dir[0];
                            int new_col=col+dir[1];
                            if(new_row<m&&new_row>=0&&new_col<n&&new_col>=0&&grid[new_row][new_col]==0&&!visited[new_row][new_col])
                            {
                                total[new_row][new_col]+=cnt;
                                reach[new_row][new_col]++;
                                visited[new_row][new_col]=true;
                                queue.offer(new int[]{new_row,new_col});
                            }
                        }
                    }
                        cnt++;
            }    
                
                }
            }
        }
        
        int res=Integer.MAX_VALUE;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0&&reach[i][j]==building)
                    res=Math.min(res, total[i][j]);
            }
        }
        return res!=Integer.MAX_VALUE?res:-1;
    }
}
