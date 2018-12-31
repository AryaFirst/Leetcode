class Solution {
    public int nextGreaterElement(int n) {
        char []num=(n+"").toCharArray();
        int index=-1;
        for(int i=0;i<num.length-1;i++){
            if(num[i]<num[i+1]){
                index=i;
                
            }
        }
        if(index==-1) return -1;
        char sm=num[index+1];
        int smindex=index+1;
        for(int i=index+1;i<num.length;i++){
            if(num[i]<sm&&num[i]>num[index])
                {
                smindex=i;
                sm=num[i];
            }
        }
        char tmp=num[index];
        num[index]=sm;
        num[smindex]=tmp;
        Arrays.sort(num, index+1,num.length);
         long val = Long.parseLong(new String(num));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }
}
