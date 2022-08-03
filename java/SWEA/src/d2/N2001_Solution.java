package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2001_Solution {

	public static void main(String args[]) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N+1][N+1];
			for(int i=1; i<N+1; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for(int j=1; j<N+1; j++) {
					int x = Integer.parseInt(st.nextToken());
					map[i][j] = map[i][j-1]+map[i-1][j]-map[i-1][j-1]+x;
				}
			}
			
			int maxValue = -1;
			for (int i = M; i < N+1; i++) {
				for (int j = M; j < N+1; j++) {
					int value = map[i][j] - map[i-M][j] - map[i][j-M] + map[i-M][j-M];
					if(value > maxValue)
						maxValue = value;
				}
			}
			sb.append("#").append(test_case).append(" ").append(maxValue).append("\n");
		}
		System.out.println(sb);
	}
}