class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m=boxGrid.length;
        int n=boxGrid[0].length;
        
        // for(int i=0;i<m;i++){
        //     int prev=0;

        //    for(int j=1;j<n;j++){
        //     if(boxGrid[i][j]=='#'&&boxGrid[i][prev]=='#'){
        //        continue;
        //     }else if(boxGrid[i][j]=='.'&&boxGrid[i][prev]=='#'){
        //         boxGrid[i][j]=boxGrid[i][prev];
        //         boxGrid[i][prev]='.';
        //         prev++;
        //     }else{
        //         prev=j;
        //     }
        //    }
        // }

        for(int i=m-1;i>=0;i--){
            int prev=n-1;
            for(int j=n-2;j>=0;j--){
                if(boxGrid[i][prev]=='.'&&boxGrid[i][j]=='#'){
                    boxGrid[i][prev]=boxGrid[i][j];
                    boxGrid[i][j]='.';
                    prev--;
                }else if(boxGrid[i][prev]=='.'&&boxGrid[i][j]=='.'){
                    continue;
                    }else{
                    prev=j;
                }
            }
        }

//OPTIMAL
// for (int i = 0; i < m; i++) {
//             int write = n - 1;  // rightmost position where a stone can fall

//             for (int j = n - 1; j >= 0; j--) {
//                 if (boxGrid[i][j] == '*') {
//                     write = j - 1; // reset gravity boundary
//                 } else if (boxGrid[i][j] == '#') {
//                     boxGrid[i][j] = '.';
//                     boxGrid[i][write] = '#';
//                     write--;
//                 }
//             }
//         }

        char[][] array=new char[n][m];
        for(int i=0;i<n;i++){
            int row=m-1;
            for(int j=0;j<m;j++){
                array[i][j]=boxGrid[row--][i];
            }
        }

        return array;
    }
}