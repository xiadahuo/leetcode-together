class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
       boolean[] isUsed = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, res, new ArrayList<>(), isUsed);
        return res;
    }
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] isUsed){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(isUsed[i] == true) continue;
            if(i != 0 && nums[i] == nums[i-1] && !isUsed[i-1]) continue;
            temp.add(nums[i]);
            isUsed[i] = true;
            helper(nums, res, temp, isUsed);
            isUsed[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}