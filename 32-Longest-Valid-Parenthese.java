class Solution {
    public int longestValidParentheses(String s) {
        int res=0;
        int left=0,
            right=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                left++;
            else
                right++;
            if(right==left)
                res=Math.max(res, right*2);
            else if (right>left){
                right=0;
                left=0;
            }
        }
         right=0;
            left=0;
        for(int i=s.length()-1;i>=0;i--){
           
            if(s.charAt(i)=='(')
                left++;
            else
                right++;
            if(right==left)
                res=Math.max(res, left*2);
            else if (left>right){
                right=0;
                left=0;
            }
        }
        return res;
    }
}
