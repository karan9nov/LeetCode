class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s2.length() < s1.length()) return false;

        HashMap<Character, Integer> m1 = new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            m1.put(s1.charAt(i), m1.getOrDefault(s1.charAt(i), 0) + 1);
            m2.put(s2.charAt(i), m2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        int remove = 0;
        for (int i = s1.length(); i < s2.length(); i++) {

            // System.out.println(m1);
            // System.out.println(m2);

            if (m1.equals(m2)) return true;

            m2.put(s2.charAt(remove), m2.get(s2.charAt(remove)) - 1);
            if (m2.get(s2.charAt(remove)) == 0)
                m2.remove(s2.charAt(remove));

            remove++;

            m2.put(s2.charAt(i), m2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        // System.out.println(m1);
        // System.out.println(m2);

        return m1.equals(m2);

    }
}
