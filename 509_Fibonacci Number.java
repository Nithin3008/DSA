// 509. Fibonacci Number

// The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is


class Solution {
    public int fib(int n) {
        return nthFib(n,new HashMap<Integer,Integer>());
    }
    public int nthFib(int n,HashMap<Integer,Integer>memo)
    {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int currentKey=n;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int num1=nthFib(n-1,memo);
        int num2=nthFib(n-2,memo);
        
        memo.put(currentKey,num1+num2);
        return(num1+num2);
    }
}
//here also same as 70th problem we are using hashmap to speed the performance