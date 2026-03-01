class Solution {

    public int firstOccur(int []nums, int target) {
        int left = 0, right = nums.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;

    }

    public int lastOccur(int []nums, int target) {
        int left = 0, right = nums.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public int[] searchRange(int[] nums, int target) {
        int []result=new int[2]; 
        result[0]=-1;
        result[1]=-1;
        if(nums.length==0) return result;
        result[0]= firstOccur(nums, target);
        result[1]= lastOccur(nums, target);
        return result;
    }
}