class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int indexOne = minCost(cost, 0, new HashMap<Integer,Integer>());
        
        int indexTwo = minCost(cost, 1, new HashMap<Integer,Integer>());
        
        return Math.min(indexOne, indexTwo);
    }
    
    public int minCost(int[] cost, int currentIndex, HashMap<Integer, Integer> memo) {
        if(currentIndex > cost.length-1) {
            return 0;
        }
        
        int currentKey = currentIndex;
        
        if(memo.containsKey(currentKey)) {
            return memo.get(currentKey);
        }
        
        int stepOne = cost[currentIndex] + minCost(cost, currentIndex + 1, memo);
        int stepTwo = cost[currentIndex] + minCost(cost, currentIndex + 2, memo);
        
        memo.put(currentKey, Math.min(stepOne,stepTwo));
        
        return memo.get(currentKey);
    }
}