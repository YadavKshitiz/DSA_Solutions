class Solution {
    boolean possible(int[] nums,int days,int m,int  k){
        int count=0;
        int totalB=0;
        for(int n : nums){
            if(n <= days){
                count++;
            }else{
                totalB +=(count / k);
                count=0;
            }
        }
        totalB += (count / k);
        if(totalB >= m){
            return true;
        }
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m * k > bloomDay.length){
            return -1;
        }
        int left=Integer.MAX_VALUE;
        int right=Integer.MIN_VALUE;
        int ans=-1;
        for(int n: bloomDay){
            left=Math.min(left,n);
            right=Math.max(right,n);
        }
        while(left <= right){
            int mid=left +(right - left) / 2;
            if(possible(bloomDay,mid ,m ,k) == false){
                left= mid + 1;
            }else{
                ans=mid;
                right= mid - 1;
            }
        }
       return ans;
    }
}