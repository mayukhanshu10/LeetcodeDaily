class Solution {
    public int[][] transpose(int[][] matrix) {
        
        //Yaha pe har element ka points [row,col] hoga, hume bas [row,col] ko [col,row karna hai]
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int arr[][]= new int[col][row];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[j][i]=matrix[i][j];
            }
        }
        return arr;
    }
}