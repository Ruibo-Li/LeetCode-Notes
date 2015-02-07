public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String> ();
        String[] letters = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder tmp = new StringBuilder();
        helper(digits,res,tmp,letters,0);
        return res;
    }
    public void helper(String digits,List<String> res,StringBuilder tmp,String[] letters,int start){
        if(start==digits.length()) {
            res.add(tmp.toString());
            return;
        }
        String cur = letters[digits.charAt(start)-'2'];
        for(int j=0;j<cur.length();j++){
            tmp.append(cur.charAt(j));
            helper(digits,res,tmp,letters,start+1);
            tmp.deleteCharAt(tmp.length()-1);
        }
    }
}