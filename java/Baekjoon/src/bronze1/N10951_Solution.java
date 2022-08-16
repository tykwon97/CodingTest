package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N10951_Solution {
	//예외처리라니... 예상도 못했네..
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		while(st.countTokens() != 0) {
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(a+b);
			try {
				st = new StringTokenizer(in.readLine()," ");
			} catch (Exception e) {
				break;
			}
		}
	}

}
