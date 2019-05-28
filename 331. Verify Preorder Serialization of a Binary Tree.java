class Solution {

    /** Using in and out degree */
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node: nodes) {
            diff--;
            if (diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }

    /** Using a Stack */
    public boolean isValidSerializationUsingStack(String preorder) {

        Stack<String> stack = new Stack<>();

        String[] arr = preorder.split(",");

        for (String s: arr) {
            System.out.println("node:" + s);
            if (s.equals("#")) {

                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.isEmpty()) return false;
                    stack.pop();
                }
                stack.push(s);
            } else {
                stack.push(s);
            }
            System.out.println("stack:" + stack);
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }
}
