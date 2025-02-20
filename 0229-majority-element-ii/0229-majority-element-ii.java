class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        int cnt1 = 0, cnt2 = 0;

        for(int i =0;i<n;i++){
            if(cnt1 == 0 && nums[i]!=ele2){
                ele1=nums[i];
                cnt1++;
            }else if (cnt2 == 0 && nums[i]!=ele1){
                ele2=nums[i];
                cnt2++;
            }else if(ele1==nums[i]){
                cnt1++;
            }else if(ele2==nums[i]){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> ansList = new ArrayList<>();
        cnt1 =0; cnt2=0;
        for(int i=0;i<n;i++){
            if (nums[i]==ele1){
                cnt1++;
            }
            if(nums[i]==ele2){
                cnt2++;
            }
        }
        int target = (int)(n/3)+1;

        if(cnt1>=target){
            ansList.add(ele1);
        }
        if(cnt2>=target){
            ansList.add(ele2);
        }

        return ansList;
    }
}