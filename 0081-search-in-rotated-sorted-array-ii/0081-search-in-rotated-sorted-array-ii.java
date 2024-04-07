class Solution {
    public boolean search(int[] nums, int target) {
        
        int l=0;
        int h=nums.length-1;
        
        while(l<=h){
            int mid = l+(h-l)/2;
            if(nums[mid]==target){
                return true;
            }
            
            if(nums[l]==nums[mid] && nums[mid]==nums[h]){
                l++;
                h--;
                continue;
            }
            
            //Find if left half is sorted?
            if(nums[l]<=nums[mid]){
                //No Find if target exist in sorted(left) part
                if(nums[l]<=target && target<=nums[mid]){
                    h=mid-1;
                }else{
                    l=mid+1;
                }
            }else{ //Right half is sorted
                //Finding if target is in sorted(right) half
                if(nums[mid]<=target && target<=nums[h]){
                    l=mid+1;
                }else{
                    h=mid-1;
                }
            }
        }
        return false;
        
    }
}