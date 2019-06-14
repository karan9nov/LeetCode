package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */

class FreqStack {

    int maxFreq = 0;
    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> stackMap;

    public FreqStack() {
        freqMap = new HashMap<>();
        stackMap = new HashMap<>();
    }

    public void push(int x) {
        freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        maxFreq = Math.max(maxFreq, freqMap.get(x));

        if (stackMap.containsKey(freqMap.get(x))) {
            stackMap.get(freqMap.get(x)).push(x);
        } else {
            Stack<Integer> tempStack = new Stack<>();
            tempStack.push(x);
            stackMap.put(freqMap.get(x), tempStack);
        }
    }

    public int pop() {
        if (!stackMap.isEmpty()) {

            Stack<Integer> tempStack = stackMap.get(maxFreq);
            int retval = tempStack.pop();
            if (tempStack.isEmpty()) {
                stackMap.remove(maxFreq);
                maxFreq-=1;
            }
            freqMap.put(retval, freqMap.get(retval) - 1);
            if (freqMap.get(retval) == 0) freqMap.remove(retval);
            return retval;
        }
        return -1;
    }
}
