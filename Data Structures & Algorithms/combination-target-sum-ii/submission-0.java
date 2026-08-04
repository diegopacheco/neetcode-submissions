class Solution {
 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int s, int[] candidates, int target, ArrayList<Integer> path, List<List<Integer>> result) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = s; i < candidates.length; ++i) {
            if (i > s && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(i + 1, candidates, target - candidates[i], path, result);
            path.remove(path.size() - 1);
        }
    }
}
