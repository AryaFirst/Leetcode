class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new LinkedList<>();
        char [][]grid=new char[n][n];
        for(char []row:grid)
            Arrays.fill(row, '.');
        dfs(res, 0,grid);
        return res;                                                                                                                                   
        }
        public void dfs(List<List<String> >res, int col, char[][]grid){
            if(col==grid.length)
                res.add(constructor(grid));
            for(int i=0; i<grid.length;i++){
                if(check(grid, i, col)){
                    grid[i][col]='Q';
                    dfs(res, col+1, grid);
                    grid[i][col]='.';
                }
            }
        }
        public boolean check (char[][]grid, int x, int y){
            for(int i=0; i<grid.length;i++){
                for(int j=0;j<y;j++){
                    if(grid[i][j]=='Q'&&((x==i)||(x-y==i-j)||(x+y==i+j)))
                        return false;
                }
            }
            return true;
        }
        public List<String> constructor(char [][]grid){
            List <String> res=new LinkedList<>();
            for(int i=0;i<grid.length;i++){
                String little="";
                for(int j=0; j<grid.length;j++)
                    little+=grid[i][j];
                res.add(little);
                
            }
            return res;
        }
}
