class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(k, 1, n, res, new ArrayList<>());
        return res;
    }
    public void dfs(int k, int start, int n, List<List<Integer>> res, List<Integer> temp){
        if(k == 0){
            if(n == 0){
                res.add(new ArrayList<>(temp));
                return;
            }
        }
        for(int i = start; i <= 9; i++){
            temp.add(i);
            dfs(k-1, i+1, n-i, res, temp);
            temp.remove(temp.size()-1);
        }
    }
}