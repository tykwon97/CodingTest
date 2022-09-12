package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1389_Solution {
	public static boolean[][] map;
	public static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			map[A][B] = true;
			map[B][A] = true;
		}
		
		game();
	}

	private static void game() {
		int minValue = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 1; i <= N; i++) {
			Queue<int[]> queue = new ArrayDeque<int[]>();
			boolean[] isSelected = new boolean[N+1];
			queue.offer(new int[] {i,0});
			int value = 0;
			while(!queue.isEmpty()) {
				int[] arr = queue.poll();
				int index = arr[0];
				int count = arr[1];
				if(!isSelected[index]) {
					isSelected[index] = true;
					value += count;
					for (int j = 1; j <= N; j++) {
						if(map[index][j])
							queue.offer(new int[] {j,count+1});
					}
				}
			}
			if(minValue > value) {
				minValue = value;
				minIndex = i;
			}
			
		}
		System.out.println(minIndex);
	}
}
