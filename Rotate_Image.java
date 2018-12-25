class Solution {
    public void rotate(int[][] matrix) {
        reverseUpDown(matrix);
       for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++)
                swap(matrix,i,j);
        }
       
    }
    public void reverseUpDown(int [][]matrix){
        int j=matrix.length;
        
        int i=-1;
        while(++i<--j){
        
            for(int k=0;k<matrix[0].length;k++){
                int tmp=matrix[i][k];
                matrix[i][k]=matrix[j][k];
                matrix[j][k]=tmp;
                
            }
         
            
        }
    }
    
    public void swap(int [][]matrix, int i, int j){
        int tmp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=tmp;
    }
}
