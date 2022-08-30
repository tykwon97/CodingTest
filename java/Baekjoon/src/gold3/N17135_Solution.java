package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N17135_Solution {
	
	public static int N;
	public static int M;
	public static int D;
	public static int maxKill;
	public static int enemyNum;
	public static int[] loc;
	public static int[][] arr;
	public static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		enemyNum = 0; //궁수 인원
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1)
					enemyNum++;
			}
		}
		
		loc = new int[3];
		maxKill = 0;
		comb(0,0);
		System.out.println(maxKill);
		
	}

	private static void comb(int cnt,int start) {
		if(cnt == 3) {
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = arr[i][j];
				}
			}
			int enemy = enemyNum;
			int kill = 0;
			while(enemy > 0) {
				int nowKill = 0;
				// 궁수 공격
				nowKill += attack(loc);
				
				enemy -= nowKill;
				kill += nowKill;
				
				// 적 공격
				for (int i = 0; i < M; i++) {
					if(map[N-1][i] == 1)
						enemy--;
				}
				for (int i = N-1; i >= 1; i--) {
					for (int j = 0; j < M; j++) {
						map[i][j] = map[i-1][j];
					}
				}
				for (int i = 0; i < M; i++) {
					map[0][i] = 0;
						
				}
			}
			if(maxKill<kill)
				maxKill = kill;
			return;
		}
		
		for (int i = start; i < M; i++) {
			loc[cnt] = i;
			comb(cnt+1,i+1);
		}
	}

	private static int attack(int[] row) {
		LinkedList<int[]> list = new LinkedList<>();
		for (int i = 0; i < 3; i++) {
			int r = row[i];
			Queue<int[]> queue = new ArrayDeque<>();
			queue.offer(new int[] {N-1,r,0});
			
			while(!queue.isEmpty()) {
				int[] node = queue.poll();
				int x = node[0];
				int y = node[1];
				int count = node[2];
				if(x<0 || y<0 || y>=M) {
					continue;
				}
				if(count>=D)
					continue;
				if(map[x][y] == 1) {
					list.add(new int[] {x,y});
					break;
				}else {
					queue.offer(new int[] {x,y-1,count+1});
					queue.offer(new int[] {x-1,y,count+1});
					queue.offer(new int[] {x,y+1,count+1});
				}
			}
		}
		int count = 0;
		for(int[] ar : list) {
			if(map[ar[0]][ar[1]] != 0) {
				count++;
				map[ar[0]][ar[1]] = 0;
			}
		}
		return count;
	}
}
