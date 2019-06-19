class Solution {
    public String multiply(String num1, String num2) {

		int[] ans = new int[num1.length() + num2.length()];
		
		for (int j = num2.length() - 1; j >= 0; j--) {
			for (int i = num1.length() - 1; i >= 0; i--) {
				int a = (int) num2.charAt(j) - (int) '0';
				int b = (int) num1.charAt(i) - (int) '0';
				int res = a*b;
				res = ans[i+j+1] + res;
				ans[i+j+1] = res%10;
				ans[i+j] = res/10 + ans[i+j];
			}
		}
        
        int start = 0;
		while (start < ans.length - 1 && ans[start] == 0)
			start++;
		
		StringBuilder sb = new StringBuilder();
		for (;start<ans.length;start++)
			sb.append(ans[start]);
		
		return sb.toString();
	}
}