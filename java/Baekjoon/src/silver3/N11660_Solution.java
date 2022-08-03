package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11660_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][n];
		int[][] sum = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(j == 0)
					sum[i][j] = arr[i][j];
				else
					sum[i][j] = sum[i][j-1] + arr[i][j];
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int total = 0;
			for(int j = x1-1; j<=x2-1; j++) {
				if(y1== 1 || y2 == 1) 
					total += sum[j][y2-1];
				else 
					total += (sum[j][y2-1]-sum[j][y1-2]);
			}
			sb.append(total+"\n");
		}
		System.out.println(sb);
	}
}
