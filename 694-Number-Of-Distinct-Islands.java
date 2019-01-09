class Solution {
    private static int[][] grid;
    private static boolean [][]seen;
    private static Set<Integer> shape;
    public int numDistinctIslands(int[][] grid) {
        this.grid=grid;
        seen=new boolean[grid.length][grid[0].length];
        Set<Set<Integer>> shapes=new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                shape=new HashSet<>();
                shape(i,j,i,j);
                if(shape.size()>0)
                    shapes.add(shape);
            }
        }
        return shapes.size();
    }
    public void shape(int r,int c, int r0, int c0){
       
     
        if(r>=0&&r<grid.length&&c>=0&&c<grid[0].length&&grid[r][c]==1&&seen[r][c]==false){
               seen[r][c]=true;
            shape.add((r-r0)*2*grid[0].length+(c-c0));
             shape(r+1,c,r0,c0);
             shape(r-1,c,r0,c0);
             shape(r,c+1,r0,c0);
             shape(r,c-1,r0,c0);
        }
    
}
}
