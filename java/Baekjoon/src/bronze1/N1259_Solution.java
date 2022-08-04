package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1259_Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String x = in.readLine();
		
		while(!x.equals("0")){
			int len = x.length();
			boolean flag = true;
			for (int i = 0; i < len/2; i++) {
				if(x.charAt(i) != x.charAt(len-1-i)) {
					flag = false;
					break;
				}
			}
			
			if(flag)
				sb.append("yes\n");
			else
				sb.append("no\n");
			
			x = in.readLine();
		}
		
		System.out.println(sb);
	}
}
