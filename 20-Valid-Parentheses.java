class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch==')'){
                if(stack.size()!=0&&stack.peek()=='(')
                    stack.pop();
                else
                    stack.push(ch);
            }
            else if(ch==']'){
                if(stack.size()!=0&&stack.peek()=='[')
                    stack.pop();
                else
                    stack.push(ch);
            }
             else if(ch=='}'){
                if(stack.size()!=0&&stack.peek()=='{')
                    stack.pop();
                else
                    stack.push(ch);
            }
            else
                stack.push(ch);
        }
        return stack.size()==0;
    }
}
