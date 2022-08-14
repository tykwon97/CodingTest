package noLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N4012_Solution {
	public static int[][] arr;
	public static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=testCase; tc++) {
			int n = Integer.parseInt(in.readLine());

			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			comb(n,0,0,0);

			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static void comb(int n, int index, int flag, int cnt) {
		if(cnt == n/2) {
			int[] a1 = new int[n/2];
			int[] a2 = new int[n/2];
			int c1 = 0;
			int c2 = 0;
			for (int i = 0; i < n; i++) {
				if( (flag & 1<<i) != 0) {
					a1[c1++] = i;
				}else {
					a2[c2++] = i;
				}
			}
			int aTotal = 0;
			int bTotal = 0;
			for (int i = 0; i < n/2; i++) {
				for (int j = i+1; j < n/2; j++) {
					aTotal += arr[a1[i]][a1[j]] + arr[a1[j]][a1[i]];
					bTotal += arr[a2[i]][a2[j]] + arr[a2[j]][a2[i]];
				}
			}
			
			int value = Math.abs(aTotal-bTotal);
			
			if(min > value)
				min = value;
			return;
		}

		for (int i = index; i < n; i++) {
			if( (flag & 1<<i) != 0) continue;
			comb(n, i+1, flag | 1<<i, cnt+1);
		}

	}
	
}
