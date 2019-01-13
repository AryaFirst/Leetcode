class Solution {
    public int peakIndexInMountainArray(int[] A) {
        return peakIndex(0, A.length-1, A);
       
    }
    public int peakIndex(int start, int end , int[]A){
         int i=start;
         int j=end;
      
            int mid=i+(j-i)/2;
            if(isPeak(mid, A))
                return mid;
            if(A[mid]<A[mid+1])
                return peakIndex(mid+1,end, A);
            if(A[mid]<A[mid-1])
                return peakIndex(start, mid-1, A);
        if(start==end) return start;
        
        return 0;
    }
    public boolean isPeak(int i, int[]A)
    {
        return A[i]>A[i-1]&&A[i]>A[i+1];
    }
}
