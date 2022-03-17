// 746. Min Cost Climbing Stairs

// You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

// You can either start from the step with index 0, or the step with index 1.

// Return the minimum cost to reach the top of the floor.

 

// Example 1:

// Input: cost = [10,15,20]
// Output: 15
// Explanation: You will start at index 1.
// - Pay 15 and climb two steps to reach the top.
// The total cost is 15.



class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer,Integer>memo = new HashMap<>();
        return(Math.min(minCost(cost,0,memo),minCost(cost,1,memo)));
    }
    private int minCost(int []cost,int currentIndex,HashMap<Integer,Integer>memo)
    {
        if(currentIndex==cost.length)
        {
            return 0;
        }
        if(currentIndex>cost.length)
        {
            return 1001;
        }
        int currentKey=currentIndex;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int oneStep=cost[currentIndex]+minCost(cost,currentIndex+1,memo);
        int twoStep=cost[currentIndex]+minCost(cost,currentIndex+2,memo);
        memo.put(currentKey,Math.min(oneStep,twoStep));
        return Math.min(oneStep,twoStep);
    }
}