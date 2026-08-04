class Solution {
 
   public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0,candidates,target,new ArrayList<>(),res);
        return res;
    }

    private void dfs(int s,int[] candidates,int target,List<Integer> path,List<List<Integer>> res){
        if (target <0){
            return;
        }
        if (target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=s; i<candidates.length; ++i){
            path.add(candidates[i]);
            dfs(i,candidates,target-candidates[i],path,res);
            path.remove(path.size()-1);
        }
    }
}
