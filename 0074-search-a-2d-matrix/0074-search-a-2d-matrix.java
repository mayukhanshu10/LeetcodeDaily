class Solution {

    /*
    Intution: When we flatten 2D matrix into 1D we get [1,3,5,7,10,11,16,20,23,30,34,60]. Now we can apply
    Binary search into it. But converting it will cause again O(m*n) tc. Therefore we will take its 
    low and high as 0 and row*col-1 respectively. Now we will assume 1D arr (i.e. flattend array) in our mind
    and perform Binary search, and as soon as we hit any element, the process to get that idx element value from 2D matric is
    row = mid/col;
    col = mid%col;  (REMEMBER THIS IS HOW WE GET IDX OF ELEMENT IN 2D MATRIX) 
    Now just check if arr[row][col] matches target else BS on left or right half.

   */



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