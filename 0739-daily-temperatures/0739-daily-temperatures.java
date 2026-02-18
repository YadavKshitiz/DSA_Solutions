import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n= temperatures.length;
        int [] array=new int[n];
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                int poop=stack.pop();
                array[poop]=i-poop;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int poop=stack.pop();
            array[poop]=0;
        }

        return array;
    }
}
