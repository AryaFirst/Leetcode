class Solution {
    private static int [][]moves={{-1,0},{1,0},{0,-1},{0,1}};
    private static Queue<int []> queue=new LinkedList<>();
    public void wallsAndGates(int[][] rooms) {
        
        int m=rooms.length;
        if(m==0) return;
        int n=rooms[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j]==0)
                    queue.add(new int[]{i,j});
            }
        }
        while(queue.size()!=0){
            int [] cur=queue.poll();
            int row=cur[0];
            int col=cur[1];
            int num=rooms[row][col];
            for(int [] move:moves){
                int r=row+move[0];
                int c=col+move[1];
                if(r>=0&&r<m&&c>=0&&c<n&&rooms[r][c]==Integer.MAX_VALUE)
                {rooms[r][c]=num+1;queue.add(new int[]{r,c});}
            }
        }
        
    }
}
