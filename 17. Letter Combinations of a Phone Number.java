class Solution {

    Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> retval = new ArrayList<>();

        letterCombinations(digits, 0, new StringBuilder(), retval);

        return retval;

    }

    private void letterCombinations(String digits, int i, StringBuilder sb, List<String> retval) {

        if (digits.length() == 0) return;

        if (i == digits.length()) {
            retval.add(sb.toString());
            return;
        }

        for (char c: map.get(digits.charAt(i)).toCharArray()) {
            sb.append(c);
            letterCombinations(digits, i+1, sb, retval);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
