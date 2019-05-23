class Solution {
    public String decodeString(String s) {

        Stack<String> stack = new Stack<>();

        for (char c: s.toCharArray()) {

            if (c != ']') {
                // Keep on pushing on the stack if we dont find a closing brace
                stack.push(String.valueOf(c));
            } else {
                // if closing brace is found then we extract from the stack until opening brace is found
                // And build the string that needs to in the main string
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    temp.insert(0, stack.pop());
                }

                // pop the opening brace
                stack.pop();

                // get the count and generate the string
                StringBuilder countString = new StringBuilder();
                while (!stack.isEmpty() && stack.peek().matches("\\d")){
                    countString.insert(0, stack.pop());
                    if (!stack.isEmpty() && !stack.peek().matches("\\d")) {
                        break;
                    }
                }
                int count = Integer.parseInt(countString.toString());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < count; i++){
                    sb.append(temp);
                }
                stack.push(sb.toString());
            }
        }

        // ultimately build the string with all the values in the stack
        StringBuilder retval = new StringBuilder();
        while (!stack.isEmpty()) {
            retval.insert(0, stack.pop());
        }

        return retval.toString();
    }
}
