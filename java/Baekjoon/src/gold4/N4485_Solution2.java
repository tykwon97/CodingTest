package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N4485_Solution2 {
	public static int N;
	public static int[][] map;
	public static int[][] costs;
	public static int[] dx = {1,0,-1,0};
	public static int[] dy = {0,1,0,-1};

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		int Index = 1;
		do {
			map = new int[N][N];
			costs = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(costs[i], Integer.MAX_VALUE);
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0,0,0);
			
			sb.append("Problem ").append(Index++).append(": ").append(costs[N-1][N-1]).append("\n");
			N = Integer.parseInt(in.readLine());
		}while((N != 0));
		System.out.println(sb);
		
		
	}

	private static void dfs(int x, int y, int cost) {
		cost = cost+map[x][y];
		
		if(cost >= costs[x][y])
			return;
		else
			costs[x][y] = cost;
		
		if(x == N-1 && y==N-1)
			return;
		
		for (int i = 0; i < 4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			
			if(nextX<0 || nextX>=N || nextY<0 || nextY>=N)
				continue;
			
			dfs(nextX,nextY,cost);
			
			if(nextX == N-1 && nextY == N-1)
				break;
		}
	}
}