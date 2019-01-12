class Solution {
    public int titleToNumber(String s) {
        int pro=1;
        int res=0;
        for(int i=s.length()-1;i>=0;i--){
            int cur=s.charAt(i)-'A'+1;
            res+=cur*pro;
            pro*=26;
        }
        return res;
    }
}
