class Solution {
    public int hIndex(int[] citations) {
        reverse(citations);
        int h=0;
        for(int i=0;i<citations.length;i++){
            if((i+1)>citations[i]){
                return h;
            }
            h++;
        }
        return h;
    }

    public static void reverse(int[] array)
    {
        // Length of the array
        int n = array.length;

        // Swapping the first half elements 
        // With last Half Elements
        for (int i = 0; i < n / 2; i++) {

            // Storing the first half elements temporarily
            int temp = array[i];

            // Assigning the first half
              // to the last half
            array[i] = array[n - i - 1];

            // Assigning the last half
            // to the first half
            array[n - i - 1] = temp;
        }
    }
}