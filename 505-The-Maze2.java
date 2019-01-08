class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int [][] directions={{-1,0},{1,0},{0,-1},{0,1}};
        int [][] cnt=new int [maze.length][maze[0].length];
        for(int []row:cnt)
        Arrays.fill(row,Integer.MAX_VALUE);
        Queue<int[]> queue=new LinkedList<>();
        queue.add(start);
        cnt[start[0]][start[1]]=0;
        while(queue.size()!=0){
            int []cur=queue.poll();
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
                    queue.add(new int[]{rnew,cnew});
                }
            }
        }
        return cnt[destination[0]][destination[1]]!=Integer.MAX_VALUE?cnt[destination[0]][destination[1]]:-1;
    }
}
