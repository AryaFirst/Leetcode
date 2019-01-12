class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer,Integer> map;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.nums=new ArrayList<>();
        this.map=new HashMap<>();
        this.rand=new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,nums.size());
        nums.add(nums.size(),val);
        return true;
        
    
}
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index=map.get(val);
        if(index!=nums.size()-1){
            int v=nums.get(nums.size()-1);
            map.put(v,index);
            nums.set(index,v);
            
        }
        map.remove(val);
        nums.remove(nums.size()-1);
        return true;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(this.rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
