class Solution {
    public int shortestSubarray(int[] A, int K) {
        int [] B= new int [A.length+1];
        for(int i=1;i<A.length+1;i++)
            B[i]=B[i-1]+A[i-1];
        
        Deque<Integer> dq=new LinkedList<>();
        int res=Integer.MAX_VALUE; 
        
        for(int i=0;i<A.length+1;i++){
            
            while(dq.size()!=0&&B[i]-B[dq.peekFirst()]>=K)
                res=Math.min(res, i-dq.pollFirst());
            while(dq.size()!=0&&B[i]<=B[dq.peekLast()])
                dq.removeLast();
            dq.addLast(i);
        }
        return res!=Integer.MAX_VALUE?res:-1;
    }
}
