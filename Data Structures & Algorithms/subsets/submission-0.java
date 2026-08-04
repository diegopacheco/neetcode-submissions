class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums,0,new ArrayList<>(),result);
        return result;
    }

    private void dfs(int[] nums, int s, List<Integer> path,List<List<Integer>> ans){
        ans.add(new ArrayList<>(path));

        for (int i=s;i<nums.length;i++){
            path.add(nums[i]);
            dfs(nums,i+1,path,ans);
            path.remove(path.size()-1);
        }
    }
}
