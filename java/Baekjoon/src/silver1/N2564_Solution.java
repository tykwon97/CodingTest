package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2564_Solution {
	
	public static int[] dx = {1,0,-1,0};
	public static int[] dy = {0,1,0,-1};
	public static boolean[][] isVisited;
	public static boolean[][] isShop;

	public static int startX;
	public static int startY;
	public static int column;
	public static int row;
	public static int num;
	public static int total;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		column = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[row+1][column+1];
		isShop = new boolean[row+1][column+1];
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				isVisited[i][j] = true;
			}
		}
		
		num = Integer.parseInt(in.readLine());
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int dir = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(dir == 1) {
				isShop[0][c] = true;
			}else if(dir == 2){
				isShop[row][c] = true;
			}else if(dir == 3){
				isShop[c][0] = true;
			}else if(dir == 4){
				isShop[column][c] = true;
			}
		}
		
		st = new StringTokenizer(in.readLine()," ");
		int dir = Integer.parseInt(st.nextToken());
		int c  = Integer.parseInt(st.nextToken());
		if(dir == 1) {
			startX = 0;
			startY = c;
		}else if(dir == 2){
			startX = row-1;
			startY = c;
		}else if(dir == 3){
			startX=c;
			startY=0;
		}else if(dir == 4){
			startX=column-1;
			startY=c;
		}
//		for (int i = 0; i < row+1; i++) {
//			for (int j = 0; j < column+1; j++) {
//				System.out.print(isVisited[i][j]?"O":"X");
//			}System.out.println();
//		}
//		System.out.println();
//
//		for (int i = 0; i < row+1; i++) {
//			for (int j = 0; j < column+1; j++) {
//				System.out.print(isShop[i][j]?"O":"X");
//			}System.out.println();
//		}
		
		total = 0;
		bfs(startX,startY);
		
		
		System.out.println(total);
		
	}

	private static void bfs(int tempX, int tempY) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {tempX, tempY,0});
		
		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			int x = xy[0];
			int y = xy[1];
			int count = xy[2];
			System.out.println(x+" "+y);
			
			if(isShop[x][y]) {
				num--;
				count += count;
				
				if(num==0)
					return;
				
				queue.clear();
				isShop[x][y] = false;
				queue.add(new int[] {x,y});
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int nextX = x+dx[i];
				int nextY = y+dy[i];
				if(nextX<0 || nextY<0 || nextX >=row+1 || nextY>=column+1) continue;
				if(isVisited[nextX][nextY]) continue;
				queue.add(new int[] {nextX,nextY,count+1});
			}
		}
		
		
	}
}
