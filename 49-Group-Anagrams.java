class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map=new HashMap<>();
        
        for(String s:strs){
            char []a=s.toCharArray();
            Arrays.sort(a);
            String newS=String.valueOf(a);
            if(map.containsKey(newS)!=true)
                map.put(newS, new LinkedList<>());
            map.get(newS).add(s);
        }
        return new LinkedList<List<String>> (map.values());
    }
}
