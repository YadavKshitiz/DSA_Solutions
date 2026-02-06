class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int left=0,count=0,maxLen=0;
        
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
                count--;
            }else{
                count++;
            }
            maxLen=Math.max(maxLen,count);
            set.add(s.charAt(i));
        }
        return maxLen;
    }
} 