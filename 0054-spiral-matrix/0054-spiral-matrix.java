class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int count = 0;
        boolean bool=false;
        int p = -1, k = n, l = -1, o = m;
        int i = 0, j = 0;
        while (count < m * n) {
            while (j < k) {
                result.add(matrix[i][j]);
                j++;
                count++;bool=true;
            }
            if (bool) {
                p++;
                j--;
                i++;
                bool=false;
            }
if(count == m * n){return result;}
            while (i < o) {
                result.add(matrix[i][j]);
                i++;
                count++;bool=true;
            }
            if (bool) {
                k--;
                i--;
                j--;
                bool=false;
            }
if(count == m * n){return result;}

            while (j > l) {
                result.add(matrix[i][j]);
                j--;
                count++;bool=true;
            }
            if (bool) {
                o--;
                j++;
                i--;
                bool=false;
            }
if(count == m * n){return result;}

            while (i > p) {
                result.add(matrix[i][j]);
                count++;
                i--;bool=true;
            }
            if (bool) {
                l++;
                i++;
                j++;
                bool=false;
            }
            if(count == m * n){return result;}

        }
        return result;
    }
}