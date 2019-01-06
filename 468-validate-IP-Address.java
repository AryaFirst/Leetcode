class Solution {
    public String validIPAddress(String IP) {
        if(IP.length()==0) return "Neither";
        if(check4(IP)) return "IPv4";
        else if(check6(IP)) return "IPv6";
        else return "Neither";
    }
    public  boolean check4(String str){
        String []data =str.split("\\.");
       
        if(data.length!=4) return false;
        for(String check:data){
            try{
                int num=Integer.parseInt(check);
            if(num>255||num<0)
                return false;
            if(check.length()>1&&check.charAt(0)=='0')
            {System.out.println("eh");return false;}
            if(num==0&&check.charAt(0)=='-') return false;
            }catch(NumberFormatException e){
                return false;
            }
            
        }
        if(str.charAt(str.length()-1)=='.') return false;
        return true;
    }
    public boolean check6(String str){
        String []data =str.split(":");
        if(data.length!=8) return false;
        for(String check:data){
            if(check.length()==0||check.length()>4)
                return false;
            for(char ch:check.toCharArray()){
                Boolean isNumber= ch>=48&&ch<=57;
                Boolean isUpper= ch>=65&&ch<=70;
                Boolean isLower=ch>=97&&ch<=102;
                if(isNumber||isUpper||isLower)
                    continue;
                else
                    return false;
            }
           
            
        }
        if(str.charAt(str.length()-1)==':') return false;
        return true;
    }
   
}
