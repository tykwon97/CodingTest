package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N11404_Main {

	public static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		map = new int[n+1][n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(map[a][b] == 0) {
				map[a][b] = c;
			}else if(map[a][b] > c) {
				map[a][b] = c;
			}
		}
		
		for (int i = 1; i <= n; i++) {
			bfs(i,n);
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	private static void bfs(int column, int n) {
		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if(map[column][i]>0)
				queue.add(new int[] {i, map[column][i]});
		}
		
		
		while(!queue.isEmpty()) {
			int[] list = queue.poll();
			int start = list[0];
			int value = list[1];
			
			for (int j = 1; j <= n; j++) {
				if(column == j) {
					continue;
				}
				if(map[start][j] > 0) {
					int total = value + map[start][j];
					if(map[column][j] == 0) {
						map[column][j] = total;
						queue.add(new int[] {j,total});
					}else if(map[column][j] > total) {
						map[column][j] = total;
						queue.add(new int[] {j,total});
					}
				} 
			}	
		}
	}
}
