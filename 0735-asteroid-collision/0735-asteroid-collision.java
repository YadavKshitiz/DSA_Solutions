class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0){
                stack.push(asteroids[i]);
            }else{
                if(stack.isEmpty()||stack.peek()<0){
                    stack.push(asteroids[i]);
                }else{
                    int top=stack.peek();
                    while(top>0){
                        if(Math.abs(asteroids[i])==top){
                            stack.pop();
                            break;
                        }else if(top>Math.abs(asteroids[i])){
                            break;
                        }else if(top<Math.abs(asteroids[i])){
                            stack.pop();
                        }
                        if(stack.isEmpty()||stack.peek()<0){
                            stack.push(asteroids[i]);
                            break;
                        }
                        top=stack.peek();
                    }
                }
            }
        }

        int []array=new int[stack.size()];
        for(int i=array.length-1;i>=0;i--){
            array[i]=stack.peek();
            stack.pop();
        }

        return array;
    }
}