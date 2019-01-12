class Solution {
    // 1, 3, 2, -1(min,-6 max6) -2(12, )
    public int maxProduct(int[] A) {
        int r=A[0];
        for(int i=1, imax=r, imin=r;i<A.length;i++){
            if(A[i]<0)
                {int tmp=imax; imax=imin;imin=tmp;}
            imax=Math.max(A[i], A[i]*imax);
            imin=Math.min(A[i], A[i]*imin);
           
            r=Math.max(imax,r);
        }
        return r;
    }
   
}
