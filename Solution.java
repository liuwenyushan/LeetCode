package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public static String longestCommonPrefix(String[] strs) {
		class StringComparater implements Comparator<String>{
			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		}
		if(strs!=null&&strs.length>0){		
			Arrays.sort(strs,new StringComparater());
			char[] s0=strs[0].toCharArray();
			char[] se=strs[strs.length-1].toCharArray();
			int i=0;
			while(i<s0.length){
				if(se.length>=s0.length&&s0[i]==se[i]){
					i++;
				}else{
					return strs[0].substring(0,i);
				}
			}
			return strs[0];
		}	
		return null;
    }
	
	public static String longestCommonPrefix2(String[] strs){
		return "";
	}
	public String longestPalindrome(String s) {
        char[]c =s.toCharArray();
        boolean[][]dp=new boolean[c.length][c.length];
        int maxLen=0;
        int start=0;
        
        for(int i=0;i<c.length;i++){
            dp[i][i]=true;
        }
        for(int i=0;i<c.length-1;i++){
            dp[i][i+1]=(c[i]==c[i+1]);
        }
        for(int j=0;j<c.length;j++){
            for(int i=0;i<c.length;i++){
                if((i-j)>1)dp[i][j]=(c[i]==c[j]&&dp[j+1][i-1]);
                if((i-j+1)>maxLen){
                    maxLen=i-j+1;
                    start=j;
                }
            }
        }
        return s.substring(start,start+maxLen);
        
    }
	public static void main(String[] args) {
	String[] String ={"aac","ab"};
	System.out.print(Solution.longestCommonPrefix(String));
		
	}
}
