// 70. Climbing Stairs
// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?




class Solution {
    public int climbStairs(int n) {
        return totalStairs(0,n,new HashMap<Integer,Integer>());
    }
    private int totalStairs(int currentStair,int targetStair,HashMap<Integer,Integer>memo)
    {
        if(currentStair==targetStair)
            return 1;
        if(currentStair>targetStair)
            return 0;
        
        int currentKey=currentStair;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int oneStep=totalStairs(currentStair+1,targetStair,memo);
        int twoStep=totalStairs(currentStair+2,targetStair,memo);
        memo.put(currentStair,oneStep+twoStep);    
        return(oneStep+twoStep);
    }
}

// Here we used hashmap because we are converting the recursion problem to dynamic programming i.e in this problem the node values sum has been repeating instead of calculating everytime we save those values in HashMap and return them when ever we needed