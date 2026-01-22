class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result=new int[m*n];
        boolean bool=false;
        int i=0;
        int j=0;
        result[0]=mat[i][j];
        int counter=1;
        while(i<m&&j<n){
             if(bool){
                if(i<m-1){
                    i++;
                }else{j++;}

                while(i>=0&&j<n){
                    result[counter]=mat[i][j];
                    counter++;
                    j++;i--;
                }
                bool=false;j--;i++;
             }else{
                if(j<n-1){
                    j++;
                }else{
                    i++;
                }
                while(j>=0&&i<m){
                    result[counter]=mat[i][j];
                    counter++;j--;i++;
                }
                bool=true;j++;i--;
             }
        }
        
        return result;
    }
}