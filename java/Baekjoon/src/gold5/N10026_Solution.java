package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class N10026_Solution {

	/*
	 * G랑 B일때 적록색맹이므로 초기화시 한가지로 바꿔서 배열에 집어 넣으면 편하다
	 */

	public static char[][] map;
	public static char[][] map1;
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	public static int num;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		num = Integer.parseInt(in.readLine());

		map = new char[num][num];
		map1 = new char[num][num];

		for (int i = 0; i < num; i++) {
			map[i] = in.readLine().toCharArray();
			for (int j = 0; j < num; j++) {
				map1[i][j] = map[i][j] == 'G'? 'R' : map[i][j];	
			}
		} 

		int count = 0;
		int count1 = 0;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if(map[i][j] != 'X') {
					bfs(i,j,map[i][j],true);
					count ++;
				}
				if(map1[i][j] != 'X') {
					bfs(i,j,map1[i][j],false);
					count1 ++;
				}
			}
		}

		System.out.println(count+" "+count1);
	}

	private static void bfs(int startX, int startY, char c, boolean flag) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		int[] start = new int[2];
		start[0] = startX;
		start[1] = startY;
		queue.add(start);

		if(flag)
			map[startX][startY] = 'X';
		else
			map1[startX][startY] = 'X';

		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			int x = xy[0];
			int y = xy[1];

			for (int i = 0; i < 4; i++) {
				int nextX = x+dx[i];
				int nextY = y+dy[i];
				if(nextX<0 || nextX>= num || nextY<0 || nextY>=num) 
					continue;
				if(flag) {
					if(map[nextX][nextY] == c) {
						queue.add(new int[] {nextX, nextY});
						map[nextX][nextY] = 'X';
					}
				}else {
					if(map1[nextX][nextY] == c) {
						queue.add(new int[] {nextX, nextY});
						map1[nextX][nextY] = 'X';
					}
				}
			}
		}
	}
}
