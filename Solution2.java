package LeetCode;

/**
 * @author lxf
 * @name LeetCode
 * 
 */
public class Solution2 {
	public static String convert(String s, int n) {// Z×ÖÐÎ
		String result = null;
		if (s.length() <= n) {
			result = s;
			return result;
		}
		int[] indexSequence = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (i % (2 * n - 2) < n) {
				indexSequence[i] = i % (2 * n - 2);
			} else {
				indexSequence[i] = (2 * n - 2) - i % (2 * n - 2);
			}
		}

		StringBuffer resultBuffer = new StringBuffer();
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < s.length(); i++) {
				if (indexSequence[i] == j) {
					resultBuffer.append(s.charAt(i));
				}
			}
		}
		return resultBuffer.toString();
	}

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 4));
	}
}
