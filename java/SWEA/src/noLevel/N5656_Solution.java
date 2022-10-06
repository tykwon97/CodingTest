package noLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N5656_Solution {
	public static int[][] map;
//	public static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int testCase = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=testCase; tc++) {
			st = new StringTokenizer(in.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#").append(tc).append(" ").append("").append("\n");
		}
		System.out.println(sb);
	}
}
