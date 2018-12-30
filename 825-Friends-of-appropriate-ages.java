#1. binary search, time complexity O(nlogn)
class Solution {
    public int numFriendRequests(int[] ages) {
        int res=0;
        Arrays.sort(ages);
        for(int i=ages.length-1;i>=0;i--){
            int index=0;
            int bound=ages[i]/2+7;
           
            int j=i;
            while(index<j){
                int mid=index+(j-index)/2;
                if(ages[mid]<=bound)
                    index=mid+1;
                else
                    j=mid;
                
            }
           
            res+=i-index;
            
            int increase=i+1;
            while(increase<=ages.length-1&&ages[increase]==ages[i])
            {
                res++;
                increase++;
            }
          
        }
        return res;
    }
}

#2. time complexity O(N)
class Solution {
    public int numFriendRequests(int[] ages) {
        int[] numOfAge=new int[120], sumOfAge=new int[120];
        for(int i:ages){
            numOfAge[i-1]++;
        }
        for(int i=0;i<120;i++){
            if(i>0)
            sumOfAge[i]=sumOfAge[i-1]+numOfAge[i];
            else
                sumOfAge[i]=numOfAge[i];
            
        }
        int res=0;
        for(int i=1;i<=120;i++){
            if(numOfAge[i-1]==0) continue;
            int count=sumOfAge[i-1]-sumOfAge[(i)/2+7-1];
            if(count<=0) continue;
            else
            {
                
                res+=(count-1)*numOfAge[i-1];
            }
        }
        return res;
    }
}
