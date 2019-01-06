class Solution {
    public String decodeString(String s) {
       
        String res="";
        for(int i=0;i<s.length();){
            if(Character.isDigit(s.charAt(i))){
               StringBuilder tmp=new StringBuilder();
               Stack<Character> stack=new Stack<>();
               stack.push(s.charAt(i));
                i++;
               while(i<s.length()&&stack.size()>0){
                  
                   if(s.charAt(i)==']'){
                      StringBuilder little=new StringBuilder();
                      while(Character.isDigit(stack.peek())==false&&stack.peek()!='[')
                          little.append(stack.pop());
                      while(stack.peek()=='[')
                          stack.pop();
                      System.out.println(little);
                      String original=little.toString();
                      StringBuilder numstring=new StringBuilder();
                      while(stack.size()>0&&Character.isDigit(stack.peek()))
                          numstring.append(stack.pop());
                      for(int j=Integer.parseInt(numstring.reverse().toString());j>1;j--)
                          little.append(original);
                      tmp=little;
                      if(stack.size()!=0){
                          String pushnew=little.reverse().toString();
                          for(char ch:pushnew.toCharArray())
                              stack.push(ch);
                      }
                      i++;
                  }
                  else
                     stack.push(s.charAt(i++));
                    
                   
               }
              res+=tmp.reverse().toString();
            }else
                res+=s.charAt(i++);
        }
        return res;
    }
}
