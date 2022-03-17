// 198. House Robber
// Medium

// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
class Solution {
    public int rob(int[] nums) {
        return robHouse(nums,0,new HashMap<Integer,Integer>());
    }
    private int robHouse(int []nums,int currentIndex,HashMap<Integer,Integer>memo)
    {
        if(currentIndex>=nums.length)
            return 0;
        int currentKey=currentIndex;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int twoJump=nums[currentIndex]+robHouse(nums,currentIndex+2,memo);
        int oneJump=robHouse(nums,currentIndex+1,memo);//here we no need to add because he was not stealling the house 
        memo.put(currentKey,Math.max(twoJump,oneJump));
        return Math.max(twoJump,oneJump);
    }
}