package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class N1249_Solution {
	public static int N;
	public static int[][] map;
	public static int[][] count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			count = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] list = in.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(list[j]+"");
				}
				Arrays.fill(count[i], Integer.MAX_VALUE);
			}
			
			count[0][0] = 0;
			
			bfs(0,0);


			sb.append("#").append(tc).append(" ").append(count[N-1][N-1]).append("\n");
		}

		System.out.println(sb);
	}

	private static void bfs(int startX, int startY) {
		int[] dx = {+1,+0,+0,-1};
		int[] dy = {+0,+1,-1,+0};
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {startX,startY});
		
		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			int x = xy[0];
			int y = xy[1];
			for (int i = 0; i < 4; i++) {
				int newX = x+dx[i];
				int newY = y+dy[i];
				if(newX<0 || newY<0 || newX>=N || newY>=N)
					continue;
				if(count[x][y]+map[newX][newY] >= count[newX][newY])
					continue;
				count[newX][newY] = count[x][y]+map[newX][newY];

				queue.add(new int[] {newX,newY});
			}
			
		}
		
	}

	
}
