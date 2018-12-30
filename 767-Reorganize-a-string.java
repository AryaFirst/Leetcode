
//greedy 
//(n*2logK)

class Solution {
    public String reorganizeString(String S) {
       if(S.length()==0||S==null) return "";
        String res="";
        Map<Character, Integer> map=new HashMap<>();
        for(char ch:S.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);
        PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue <> (new Comparator<Map.Entry<Character,Integer>>(){
            public int compare(Map.Entry<Character,Integer> a,Map.Entry<Character,Integer>b){
                return b.getValue()-a.getValue();
                
            }
        });
        for(Map.Entry<Character,Integer>entry: map.entrySet())
            pq.offer(entry);
        while (pq.size()>0){
            Map.Entry<Character,Integer> en1=pq.poll();
            if(res.length()==0||res.charAt(res.length()-1)!=en1.getKey()){
                res=res+en1.getKey();
                en1.setValue(en1.getValue()-1);
                if(en1.getValue()!=0)
                pq.offer(en1);
            }else{
                if(pq.size()==0) return "";
                
                Map.Entry<Character,Integer> en2=pq.poll();
                res=res+en2.getKey();
                en2.setValue(en2.getValue()-1);
                if(en2.getValue()!=0)
                    pq.offer(en2);
                pq.offer(en1);
            }
        }
        return res;
    }
}
