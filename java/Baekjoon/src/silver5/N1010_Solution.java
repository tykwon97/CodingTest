package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class N1010_Solution {
	// 재귀로 풀고싶은데 시간 초과...쉽지 않아...
	public static long result;
	public static int n;
	public static int m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(in.readLine());

		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			//mCn == mC(m-n)
			if(m/2 < n) {
				n = m-n;
			}
			
			//mCn
//			result = 0;
//			calc(0,0);
//			sb.append(result).append("\n");
			
			double total = 1;
			for (int j = 0; j < n; j++) {
				total *= 1.0*(m-j)/(n-j);
			}
			total = Math.round(total);
			sb.append((int)total).append("\n");
		}

		System.out.println(sb);
	}

	private static void calc(int cnt,int index) {
		if(cnt == n) {
			result++;
			return;
		}
		for (int i = index; i <= m-n+cnt; i++) {
			calc(cnt+1,i+1);

		}
	}
}
