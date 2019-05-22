class Solution {
    public int myAtoi(String str) {

        if (str == null || str.trim().length() == 0)
            return 0;

        str = str.trim();
        int negative = 1;

        StringBuilder sb = new StringBuilder();

        if (str.charAt(0) == '-') {
            str = str.substring(1);
            negative = -1;
        } else if (str.charAt(0) == '+'){
            str = str.substring(1);
        }

        for (int i = 0; i < str.length(); i++) {

            if (!String.valueOf(str.charAt(i)).matches("\\d")){
                break;
            }
            sb.append(str.charAt(i));
        }


        if (sb.length() == 0)
            return 0;

        try {
            return negative * Integer.parseInt(String.valueOf(sb));
        } catch (Exception e) {
            if (negative == -1)
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }

    }
}
