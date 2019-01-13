class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length+1!=n) return false;
        int [] num=new int [n];
        Arrays.fill(num, -1);
        for(int i=0;i <n-1; i++){
            int x=find(num, edges[i][0]);
            int y=find(num, edges[i][1]);
            if(x==y)
                return false;
            num[x]=y;
        }
        return true;
    }
    public int find(int []num, int target){
        if(num[target]==-1) return target;
        else return find(num, num[target]);
    }
}
