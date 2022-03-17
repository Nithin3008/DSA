// 1137. N-th Tribonacci Number
// Easy

// The Tribonacci sequence Tn is defined as follows: 

// T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

// Given n, return the value of Tn.

 

// Example 1:

// Input: n = 4
// Output: 4
// Explanation:
// T_3 = 0 + 1 + 1 = 2
// T_4 = 1 + 1 + 2 = 4


class Solution {
    public int tribonacci(int n) {
     return triFib(n,new HashMap<Integer,Integer>());   
    }
    private int triFib(int currentIndex,HashMap<Integer,Integer>memo)
    {
        if(currentIndex==0)
            return 0;
        if(currentIndex==1)
            return 1;
        if(currentIndex==2)
            return 1;
        int currentKey=currentIndex;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int num1=triFib(currentIndex-1,memo);
        int num2=triFib(currentIndex-2,memo);
        int num3=triFib(currentIndex-3,memo);
        
        memo.put(currentKey,num1+num2+num3);
        
        return (num1+num2+num3);
        
    }
}