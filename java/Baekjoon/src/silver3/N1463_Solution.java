package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1463_Solution {
	
	/*
	 * 하향식으로 해결했더니 시간 초과 발생(나 뭐하니?)
	 */
	
	public static int[] cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		
		cnt = new int[n+1];
				
		Arrays.fill(cnt, n+1);
		
		// 상향식 방법
		cnt[1] = 0;
		
		// 1부터 n까지
		for (int i = 2; i <= n; i++) {
			if(i%3==0 && i/3>=1)
				cnt[i] = Math.min(cnt[i], cnt[i/3]+1);
			if(i%2==0 && i/2>=1)
				cnt[i] = Math.min(cnt[i], cnt[i/2]+1);
			if(true)
				cnt[i] = Math.min(cnt[i], cnt[i-1]+1);
		}
		System.out.println(cnt[n]);
	}
}
