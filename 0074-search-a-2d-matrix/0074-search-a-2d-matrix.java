class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        return bs(0,row*col-1,matrix,target,row,col);
    }

    private boolean bs(int l,int hi, int[][] arr, int target,int row,int col){
        while(l<=hi){
            int mid = l+(hi-l)/2;
            int r = mid/col;
            int c = mid%col;
            if(arr[r][c]==target){
                return true;
            }else if(arr[r][c]>target){
                hi=mid-1;
            }else{
                l=mid+1;
            }
        }
        return false;
    }
}