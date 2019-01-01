//O(m+n) space complexity
class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> row=new HashSet<>();
        Set<Integer> col=new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int r:row){
            for(int j=0;j<matrix[0].length;j++)
                matrix[r][j]=0;
        }
        for(int c:col){
            for(int i=0;i<matrix.length;i++)
                matrix[i][c]=0;
        }
    }
}


//// O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
      int col0=1,m=matrix.length,n=matrix[0].length;
      for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
              if(matrix[i][j]==0){
                  matrix[i][0]=0;
                 
                  if(j==0)
                      col0=0;
                  else
                       matrix[0][j]=0;
              }
          }
      }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=1;j--){
                if(matrix[0][j]==0||matrix[i][0]==0)
                    matrix[i][j]=0;
            }
            if(col0==0)
                matrix[i][0]=0;
        }
    }
}
