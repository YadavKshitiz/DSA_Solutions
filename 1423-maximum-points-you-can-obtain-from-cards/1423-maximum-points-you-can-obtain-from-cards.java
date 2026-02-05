class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int runningSum = 0;
        if(k==cardPoints.length){
            for(int i=0;i<k;i++){
                runningSum+=cardPoints[i];
            }
            return runningSum;
        }

        int minSum = 0, windowSum = 0;

        for (int i = 0; i < cardPoints.length - k; i++) {
            runningSum += cardPoints[i];
        }
        minSum = runningSum;
        windowSum = runningSum;

        for (int i = cardPoints.length - k; i < cardPoints.length; i++) {
            runningSum += cardPoints[i];
            windowSum += cardPoints[i];
            windowSum -= cardPoints[i - (cardPoints.length-k)];
            minSum = Math.min(minSum, windowSum);
        }

        return runningSum - minSum;
    }
}