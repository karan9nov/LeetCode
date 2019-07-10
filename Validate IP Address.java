package leetcode.main;

import java.util.*;
import leetcode.ds.*;

public class Solution {
    
	public boolean validateIpAddress(String s) {
		
		Boolean[][] dp = new Boolean[s.length()][5];
        System.out.println(validateIpAddressHelper(s, 0, 0, dp));
        
        for (int i = 0; i < dp.length; i++) {
        	System.out.print(i + "-->\t" );
        	for (int j = 0; j < 5; j++) {
        		System.out.print(dp[i][j] + "\t");
        	}
        	System.out.println();
        }
        
        return dp[0][0];
    }	
	
	private boolean validateIpAddressHelper(String s, int index, int count, Boolean dp[][]) {
		
		if (index == s.length() && count == 4) return true;
		
		if (index == s.length()) return false;
		if (count > 4) return false;
		if (count == 4 && index < s.length()) return false;
		
		
		
		if (dp[index][count]!=null)
			return dp[index][count];
		
		
		
		if (Integer.parseInt(s.substring(index, index + 1)) < 256) {
			System.out.println("Single Digit : " + s.substring(index, index + 1));
			if (validateIpAddressHelper(s, index + 1, count + 1, dp)) {
				// single digit
				dp[index][count] = true;
				return true;
			}
		} 
		
		if (Integer.parseInt(s.substring(index, index + 2)) < 256) {
			System.out.println("Double Digit : " + s.substring(index, index + 2));
			if (validateIpAddressHelper(s, index + 2, count + 1, dp)) {
				// double digit
				dp[index][count] = true;
				return true;
			}
		}
		
		if (Integer.parseInt(s.substring(index, index + 3)) < 256) {
			System.out.println("Triple Digit : " + s.substring(index, index + 3));
			if (validateIpAddressHelper(s, index + 3, count + 1, dp)) {
				// triple digit
				dp[index][count] = true;
				return true;
			}
		}
		
		dp[index][count] = false;
		return false;
	}
    
    public static void main(String[] args) {
		Solution s = new Solution();
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(1, 8, 6));
		list.add(Arrays.asList(1, 0, 4));
		list.add(Arrays.asList(7, 5, 3));

		int[] X = {5,2,6,1,3};
		int[] Y = { 1, 3 };

		System.out.println(s.validateIpAddress("25525411135"));
	}
}