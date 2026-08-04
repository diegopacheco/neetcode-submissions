class Solution {
private static final String[] letters = {"",    "",    "abc",
            "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits==null || digits.isEmpty()){
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        dfs(digits,0, new StringBuilder(),res);
        return res;
    }

    private void dfs(String digits, int index, StringBuilder sb, List<String> res){
        if (index==digits.length()){
            res.add(sb.toString());
            return;
        }
        String letter = letters[digits.charAt(index)-'0'];
        for(int i=0; i<letter.length(); i++){
            sb.append(letter.charAt(i));
            dfs(digits,index+1,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
