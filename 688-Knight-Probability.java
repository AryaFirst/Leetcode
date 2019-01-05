class Solution {
    int [][]moves={{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
    public double knightProbability(int N, int K, int r, int c) {
        double [][]dp=new double[N][N];
        for(double []row:dp)
            Arrays.fill(row,1);
        for(int l=0;l<K;l++){
            double [][]dpnew=new double[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    for(int []move:moves){
                        int row=i+move[0];
                        int col=j+move[1];
                        if(isIn(row,col,N))
                            dpnew[i][j]+=dp[row][col];
                    }
                }
            }
            dp=dpnew;
        }
        return dp[r][c]/Math.pow(8,K);
    }
    public boolean isIn(int row, int col,int N)
    {
        return row>=0&&row<N&&col>=0&&col<N;
    }
}
