/*n=numRows
Δ=2n-2    1                           2n-1                         4n-3
Δ=        2                     2n-2  2n                    4n-4   4n-2
Δ=        3               2n-3        2n+1              4n-5       .
Δ=        .           .               .               .            .
Δ=        .       n+2                 .           3n               .
Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
Δ=2n-2    n                           3n-2                         5n-4
*/


class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        String res="";
        int p=0;
        for(int i=0;i<numRows;i++){
            p=i;
            if(p<s.length())
            res+=s.charAt(p);
            int step1=(numRows-i-1)*2;
            int step2=(i)*2;
            while(true){
                if(p>=s.length()) break;
               
                if(step1>0){
                    p+=step1;
                    if(p<s.length())
                        res+=s.charAt(p);
                    else break;
                }
                if(step2>0){
                    p+=step2;
                    if(p<s.length())
                        res+=s.charAt(p);
                    else break;
                }
            }
            
        }
    return res;    
    }
    
}
