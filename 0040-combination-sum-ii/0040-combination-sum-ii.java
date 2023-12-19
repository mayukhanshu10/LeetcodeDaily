class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        
        Arrays.sort(candidates);
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        findCombo(0,candidates,ds,ans,target);
        return ans;
        
    }
    
    private void findCombo(int ind, int[] arr, List<Integer> ds, List<List<Integer>>                                ans,int target){
        
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]){
                continue;
            }
            
            if(arr[i]>target){
                break;
            }
            
            ds.add(arr[i]);
            findCombo(i+1,arr,ds,ans,target-arr[i]);
            ds.remove(ds.size()-1);
        }
    }
}