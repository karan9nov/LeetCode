class Solution {
    public boolean checkValidString(String s) {

        List<Character> stack = new ArrayList<>();

        return checkValidString(s, stack);
    }

    private boolean checkValidString(String s, List<Character> stack) {

        if (s.isEmpty() && stack.isEmpty()) {
            // System.out.println("true");
            return true;
        }

        if (s.isEmpty()) {
            // System.out.println("false");
            return false;
        }

        if (s.charAt(0) == '(') {

            stack.add('(');
            return checkValidString(s.substring(1), new ArrayList<>(stack));

        } else if (s.charAt(0) == ')') {

            if (stack.isEmpty()) return false;
            stack.remove(stack.size() - 1);
            return checkValidString(s.substring(1), new ArrayList<>(stack));

        } else {

            return checkValidString("(" + s.substring(1), new ArrayList<>(stack)) || checkValidString(")" + s.substring(1), new ArrayList<>(stack)) || checkValidString(s.substring(1), new ArrayList<>(stack));

        }
    }
}
