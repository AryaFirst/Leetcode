class Solution {
    public String simplifyPath(String path) {
     //   String test="//././";
     //   String [] arr=test.split("/");
    //     System.out.println(arr[1]);
        List<String> ls=new LinkedList <String> ();
        Set<String> skip=new HashSet<>(Arrays.asList(".","",".."));
        for(String tmp:path.split("/")){
            if(("..").equals(tmp)&&ls.size()!=0)ls.remove(ls.size()-1);
            else{
                if(skip.contains(tmp)==false)
                    ls.add(tmp);
            }
        }
        String res="";
        while(ls.size()!=0)
            res=res+"/"+ls.remove(0);
        return res.length()==0?"/":res;
    }
}
///// Your own stupid method..

class Solution {
    public String simplifyPath(String path) {
        List<String> tmp=new LinkedList <String> ();
        for(int i=0;i<path.length();){
            while(i<path.length()&&path.charAt(i)=='/')
                i++;
            int j=i;
            while(j<path.length()&&path.charAt(j)!='/')
                j++;
            String str=path.substring(i,j);
            if(!"..".equals(str)){
                if(!".".equals(str)&&str.length()!=0)
                    tmp.add(str);
            }else
            {
                if(tmp.size()!=0)
                    tmp.remove(tmp.size()-1);
            }
            i=j;
        }
        if(tmp.size()==0) return "/";
        String res="";
        while(tmp.size()!=0)
        {res=res+ "/";res=res+tmp.remove(0);}
        return res;
    }
}
