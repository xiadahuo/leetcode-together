class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        boolean[] isVisited = new boolean[nums.length];
        dfs(res, nums, 0, new ArrayList<>(), isVisited);
        return res;
    }
    public void dfs(List<List<Integer>> res, int[] nums, int index, List<Integer> temp,
                   boolean[] isVisited){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!isVisited[i]){
                temp.add(nums[i]);
                isVisited[i] = true;
                dfs(res, nums, index+1, temp, isVisited);
                temp.remove(temp.size()-1);
                isVisited[i] = false;
            }
        }
    }
}


//利用distinct
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        dfs(nums, res, new ArrayList<>());
        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!temp.contains(nums[i])){
                temp.add(nums[i]);
                dfs(nums, res, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}