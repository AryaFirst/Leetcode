class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        int n = intervals.size();
        while(i < n){
            if(intervals.get(i).end < newInterval.start){
                // do Nothing
                i++;
            }
            else if((intervals.get(i).start <= newInterval.start 
                     && newInterval.start <= intervals.get(i).end)
                    ||(newInterval.start <= intervals.get(i).start 
                     && intervals.get(i).start <= newInterval.end)) {
                
                newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start), Math.max(newInterval.end, intervals.get(i).end));
                intervals.remove(i);
                n--; 
            }
            else break;
        }
        
        // Added in beginning, end or disjoint set
        intervals.add(i, newInterval);  
               
        return intervals;
    }
}
