class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        String[] keyboard = {"", "", "abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(res, keyboard, digits, 0, new StringBuilder());
        return res;
    }
    public void helper(List<String> res, String[] keyboard, String digits, int index,
                      StringBuilder sb){
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }
            String str = keyboard[digits.charAt(index) - '0'];
            for(int i = 0; i < str.length(); i++){
                sb.append(str.charAt(i));
                helper(res, keyboard, digits, index+1, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        
    }
}


class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if(digits == null || digits.length() == 0) return ans;
        ans.add("");
        String[] mapping = {"abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(int i = 0; i < digits.length(); i++){
            int x = digits.charAt(i) - '2';
            while(ans.peek().length() == i){
                String temp = ans.remove();
                for(char c : mapping[x].toCharArray()){
                    ans.add(temp+c);
                }
            }
        }
        return ans;
    }
}