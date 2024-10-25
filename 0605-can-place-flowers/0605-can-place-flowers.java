class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 
                && (i == 0 || flowerbed[i - 1] == 0) 
                && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1; // Plant a flower here
                n--; // Decrease the count of flowers to be planted
                
                if (n == 0) { // If all flowers are planted, return true early
                    return true;
                }
            }
        }
        return n <= 0; // Check if we've planted all flowers
    }
}
