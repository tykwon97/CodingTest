package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1600_Solution {

	public static int K;
	public static int W;
	public static int H;
	public static int[] kdx = {+2,+1,-1,-2,+2,+1,-1,-2};
	public static int[] kdy = {+1,+2,+2,+1,-1,-2,-2,-1};
	public static int[] dx = {+0,+1,+0,-1};
	public static int[] dy = {+1,+0,-1,+0};
	
	public static int[][] map;
	public static int[][][] count;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		count = new int[H][W][2];
		for (int i = 0; i < H; i++) {
			int x = H*W+1;
			for (int j = 0; j < W; j++) {
				count[i][j][0] = x; //방문횟수
				count[i][j][1] = K; //말로 변신할 수 있는 횟수
			}
		}
		count[0][0][0] = 0;

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		monkey(0,0,K);
		
		if(count[H-1][W-1][0] == H*W+1)
			System.out.println("-1");
		else
			System.out.println(count[H-1][W-1][0]);
	}

	private static void monkey(int x, int y, int k) {
		System.out.println("x : "+x+" y :"+y);
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < W; j++) {
//				System.out.print(count[i][j][0]+" ");
//			}
//			System.out.println();
//
//		}
		// k 미사용(k다씀)

		for (int i = 0; i < 4; i++) {
			int newX = x+dx[i];
			int newY = y+dy[i];
//			System.out.println("newX : "+newX + " newY : "+newY);
			if(newX<0 || newX>=H || newY<0 || newY>=W)
				continue;
			if(map[newX][newY] == 1)
				continue;
			if(count[newX][newY][0] > count[x][y][0]+1 && count[newX][newY][1] >= k) {
				count[newX][newY][0] = count[x][y][0]+1;
				monkey(newX,newY,k);
			}
		}

		// k 사용
		if(k>0) {
			for (int i = 0; i < 8; i++) {
				int newX = x+kdx[i];
				int newY = y+kdy[i];
				if(newX<0 || newX>=H || newY<0 || newY>=W)
					continue;
				if(map[newX][newY] == 1)
					continue;
				if(count[newX][newY][0] > count[x][y][0]+1 && count[newX][newY][1] >= k) {
					count[newX][newY][0] = count[x][y][0]+1;
					count[newX][newY][1] = k-1;
					monkey(newX,newY,k-1);
				}
			}
		}
	}
}
