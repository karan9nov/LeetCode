class Solution {
    int ladderLength(String source, String target, List<String> words) {

        if (words == null || words.size() <= 0) {
            return -1;
        }

        Map<String, List<String>> wordGraph = new HashMap<>();
        buildWordGraph(words, wordGraph, source);

        return findShortestPath(wordGraph, source, target);

    }


    final private class Node {

        String word;
        int depth;

        Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return this.word + ", " + this.depth;
        }
    }

    private void buildWordGraph(List<String> words, Map<String, List<String>> wordGraph, String source){

        for(int i = 0; i < words.size(); i++) {

            if (doWordsDifferByOne(source, words.get(i))) {
                List<String> list = wordGraph.getOrDefault(source, new ArrayList<>());
                list.add(words.get(i));
                wordGraph.put(source, list);
            }

            for (int j = 0; j < words.size(); j++) {
                if (i == j) {
                    continue;
                }

                if (doWordsDifferByOne(words.get(i), words.get(j))) {
                    List<String> list = wordGraph.getOrDefault(words.get(i), new ArrayList<>());
                    list.add(words.get(j));
                    wordGraph.put(words.get(i), list);
                }
            }
        }
    }

    private boolean doWordsDifferByOne(String s1, String s2) {

        int differences = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                differences++;

                if (differences >= 2) {
                    return false;
                }
            }
        }

        return true;
    }

    private int  findShortestPath(Map<String, List<String>> wordGraph, String source, String target) {

        Set<String> visited = new HashSet<>();
        visited.add(source);

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(source, 1));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.word.equals(target)) {
                return cur.depth;
            }

            for (String w : wordGraph.get(cur.word)) {
                if (!visited.contains(w)) {
                    queue.add(new Node(w, cur.depth + 1));
                    visited.add(w);
                }
            }
        }

        return 0;
    }
}
