class Solution {
    public int missingNumber(int[] arr) { //Cyclic Sort Ques
        
        //Firstly sort the array with cyclic sort
        int i=0;
        while(i<arr.length){
            int correctIndex = arr[i];  //since array is 0 based indexing and elements are                                           also from 0-n
            if(arr[i]<arr.length && arr[i]!=arr[correctIndex]){
                int temp = arr[correctIndex];
                arr[correctIndex]=arr[i];
                arr[i]=temp;
            }else{
                i++;
            }
        }
        
        //Now since array is sorted i.e [0,1,3], find which index doesnt have correct value
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=j){
                return j;
            }
        }
        return arr.length;
    }
}