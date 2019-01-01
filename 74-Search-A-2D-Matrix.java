class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) return false;
        int m=matrix.length,n=matrix[0].length;
       if(target<matrix[0][0]||target>matrix[m-1][n-1])
           return false;
        int i=0,j=m-1;
        int index=0;
      //  find the last item which is smaller or equal than the target
        while(i<j-1){
            int mid=i+(j-i)/2;
            if(matrix[mid][0]<=target)
                i=mid;
            else
                j=mid;
        }
        if(matrix[j][0]<=target)
            index=j;
        
        else 
            index=i;
        
      
        j=n-1;
        i=0;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(matrix[index][mid]<target)
                i=mid+1;
            else if (matrix[index][mid]>target)
                j=mid-1;
            else
                return true;
        }
        return false;
    }
}
