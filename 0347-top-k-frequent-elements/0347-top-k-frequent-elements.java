class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }else{
                hm.put(nums[i],1);
            }
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll(); // Remove the least frequent element
            }
        }

        int ans[] = new int[k];
        int index = 0;
        while (!pq.isEmpty()) {
            ans[index++] = pq.poll().getKey();
        }
        return ans;
    }
}