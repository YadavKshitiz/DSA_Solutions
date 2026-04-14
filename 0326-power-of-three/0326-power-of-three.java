class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==1){
            return true;
        }else if(n<1||n%3!=0){
            return false;
        }

        boolean result=isPowerOfThree(n/3);
        if(result){
            return true;
        }
        return false;
    }
}