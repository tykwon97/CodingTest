package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N3055_Solution {
	
	/*
	 * Queue에 배열을 Type으로 넣을 수 있다.
	 */

	public static boolean[][] isVisited;
	public static int[] dx = {1,0,-1,0};
	public static int[] dy = {0,1,0,-1};
	public static char[][] map;
	public static int r;
	public static int c;
	
	static class Coordinate {
		int x;
		int y;
		int type;
		int count;
		
		public Coordinate(int x, int y, int type, int count) {
			this.x = x;
			this.y = y;
			this.type = type;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine()," ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		Coordinate go = null;
		List<Coordinate> water = new LinkedList<>();
		
		map = new char[r][c];
		for(int i=0; i<r; i++){
			map[i] = in.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if(map[i][j] == '*'){
					water.add(new Coordinate(i,j,1,1));
				}else if(map[i][j] == 'S'){
					go = new Coordinate(i,j,2,1);	
				}
			}
		}

		isVisited = new boolean[r][c];
		boolean flag = bfs(go,water);
		if(flag)
			System.out.println("KAKTUS");
	}

	private static boolean bfs(Coordinate go, List<Coordinate> water) {
		Queue<Coordinate> queue = new ArrayDeque<>();
		for (int i = 0; i < water.size(); i++) {
			queue.add(water.get(i));
		}
		
		
		
		queue.add(go);
		
		while(!queue.isEmpty()) {
			Coordinate cor = queue.poll();
			int x = cor.x;
			int y = cor.y;
			int type = cor.type;
			int count = cor.count;
			
			for (int i = 0; i < 4; i++) {
				int newX = x+dx[i];
				int newY = y+dy[i];
				
				if(newX < 0 || newX >= r || newY < 0 || newY >= c ) // 범위 벗어나는 경우
					continue;
				if(map[newX][newY] == 'D' && type == 2) {
					System.out.println(count);
					queue.clear();
					return false;	
				}
				if(isVisited[newX][newY]) {
					continue;
				}
				isVisited[newX][newY] = true;
			
				if(map[newX][newY] != '.') 
					continue;
				
				if(type == 1) {//물일때
					queue.add(new Coordinate(newX,newY,1,count+1));
					map[newX][newY] = '*';
					
				}else if(type == 2) { // 고슴도치
					queue.add(new Coordinate(newX,newY,2,count+1));
					map[newX][newY] = 'S';
				}
			}
		}
		return true;
	}
}
