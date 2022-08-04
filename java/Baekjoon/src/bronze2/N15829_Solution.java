package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N15829_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int l = Integer.parseInt(in.readLine());
		
		char[] chars = in.readLine().toCharArray();
		
		BigInteger result = new BigInteger("0");
		
		for (int i = 0; i < l; i++) {
			String x = chars[i]-'a'+1+"";
			BigInteger n = new BigInteger(x);
			BigInteger num = new BigInteger("31");
			num = num.pow(i);
			num = num.multiply(n);
			
			result = result.add(num);

		}
		BigInteger remain = new BigInteger("1234567891");
		result = result.remainder(remain);
		System.out.println(result);
		
	}
}

