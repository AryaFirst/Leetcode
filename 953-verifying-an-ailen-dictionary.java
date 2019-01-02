class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] alphabet=new int[26];
        for(int i=0;i<order.length();i++)
            alphabet[order.charAt(i)-'a']=i;
        for(int i=0;i<words.length-1;i++){
            if(!compare(words[i],words[i+1],alphabet)) 
                return false;
        }
        return true;
    }
    public boolean compare(String str1,String str2,int []alphabet){
        for(int i=0;i<Math.min(str1.length(),str2.length());i++){
            if(alphabet[str1.charAt(i)-'a']>alphabet[str2.charAt(i)-'a'])
                return false;
            else if(alphabet[str1.charAt(i)-'a']<alphabet[str2.charAt(i)-'a'])
                return true;
        }
        if(str1.length()>str2.length())
            return false;
        return true;
    }
}
