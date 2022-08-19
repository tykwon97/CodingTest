package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1260_Solution {

	
	/*
	 *  Queue를 만들 때 ArrayDeque 가 ArrayList보다 빠르다
	 *  Boolean 타입 일때 굳이 isVisited == true 를 체크 할 때 == true가 필요없다.
	 *  queue.size() == 0 -> queue.isEmpty()
	 */
	
	public static int n;
	public static boolean[][] map;	
	public static boolean[] isVisited;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken())-1;

		map = new boolean[n][n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a1 = Integer.parseInt(st.nextToken())-1;
			int a2 = Integer.parseInt(st.nextToken())-1;
			map[a1][a2] = true;
			map[a2][a1] = true;
		}


		isVisited = new boolean[n];
		dfs(v);
		
		sb.append("\n");
		
		isVisited = new boolean[n];
		bfs(v);
		
		System.out.println(sb);
	}

	private static void bfs(int cur) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		isVisited[cur] = true;
		queue.add(cur);
		
		while(!queue.isEmpty()) {
			int index = queue.poll();
			sb.append(index+1).append(" ");
			
			for (int j = 0; j < n; j++) {
				if(!isVisited[j] && map[index][j]) {
					isVisited[j] = true;
					queue.add(j);
				
				}
			}
		}
	}

	private static void dfs(int cur) {
		isVisited[cur] = true;
		sb.append(cur+1).append(" ");
		
		for (int j = 0; j < n; j++) {
			if(!isVisited[j] && map[cur][j]) {
				dfs(j);
			}
		}
	}
}
