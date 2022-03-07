// leetcode 70. Climbing Stairs

class Solution {
    public int climbStairs(int n) {
        return totalWays(n, 0, new HashMap<Integer,Integer>()); 
    }
    
    public int totalWays(int n, int currentIndex, HashMap<Integer, Integer> memo) {
        if(currentIndex == n) {
            return 1;
        }
        
        if(currentIndex > n) {
            return 0;
        }
        
        int currentKey = currentIndex;
        if(memo.containsKey(currentKey)) {
            return memo.get(currentKey);
        }
        
        int oneStep = totalWays(n, currentIndex+1, memo);
        int twoStep = totalWays(n, currentIndex+2, memo);
        
        memo.put(currentIndex, oneStep+twoStep);
        
        return oneStep + twoStep;
        
    }
}