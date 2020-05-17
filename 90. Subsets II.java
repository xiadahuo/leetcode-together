class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(res,nums,0,new ArrayList<>());
        return res;
    }
    public void helper(List<List<Integer>> res, int[] nums, int index, List<Integer> temp){
        res.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; i++){
            if(i != index && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            helper(res, nums, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}