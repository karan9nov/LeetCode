class Solution {
    public String largestNumber(int[] nums) {
        
		Comparator<String> comparator = new Comparator<String>() {
			public int compare(String a, String b) {
				return -1*(a + b).compareTo(b + a);
			}
		};
		
		String str[] = new String[nums.length];
		for (int i = 0 ;i < nums.length; i++) {
			str[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(str, comparator);
        
        if (str[0].equals("0")) return "0";
        
		StringBuilder sb = new StringBuilder();
		for (String num: str) 
			sb.append(num);
		return sb.toString();
    }
}