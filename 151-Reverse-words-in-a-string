///////#1.trim(), split();
import java.util.*;
public class ReverseWordToString {
    private static  String reverseWords(String s) {
        String space=" ";
        String[] data=s.split(" ");
        StringBuilder res=new StringBuilder();

        for(int i=data.length-1;i>=0;i--){

            String tmp=data[i];
            if(tmp.length()==0)
            {continue;}
             tmp.trim();
            res.append(tmp);
            if(i>0)
                res.append(" ");
        }
        return res.toString().trim();

    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        String res=reverseWords(str);
        System.out.println (res);
    }

}


//split multiple spaces: String[] data=s.split("\\s+");
       
////////#2.two pointers without trim

import java.util.*;
public class ReverseWordToString {
   private static void reverse(char []a, int i, int j){
       while(i<j){
           char t=a[i];
           a[i]=a[j];
           a[j]=t;
           i++;
           j--;

       }

   }

   private static void reverseWord(char []a){
       int i=0;
       int j=0;
       while(i<a.length) {
           while (i<j||i < a.length && a[i] == ' ') i++;
           while (j<i||j < a.length && a[j] != ' ') j++;
           reverse(a,i,j-1);
       }

   }

   private static String deleteSpace(char[]a){
       int i=0;int j=0;
       int l=a.length;
       while(j<l){
           while(j<l&&a[j]==' ')j++;
           while(j<l&&a[j]!=' ') a[i++]=a[j++];
           while(j<l&&a[j]==' ') j++;
           if(j<l) a[i++]=' ';


       }
       return new String(a).substring(0,i);

   }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        char[] a=str.toCharArray();
        int n=str.length();
        reverse(a,0,n-1);
        reverseWord(a);

        System.out.println(deleteSpace(a));

    }

}
