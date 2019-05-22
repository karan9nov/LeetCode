class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();

        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int res = 0;
        int i = 0;
        for (i = 0; i < s.length() - 1;) {


            if (m.get(s.charAt(i)) >= m.get(s.charAt(i + 1))) {
                res += m.get(s.charAt(i));
                i+=1;
            } else {
                res += ( m.get(s.charAt(i+1)) - m.get(s.charAt(i)));
                i+=2;
            }
        }

        // System.out.println(i);

        if (i == s.length() - 1) {
            // System.out.println(i);
            res += m.get(s.charAt(i));
        }
        return res;
    }
}
