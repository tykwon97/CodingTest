package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N17070_Solution {

	/*
	 * 멍청하게 최단 경로 구하고 있었음 ㅋㅋ;;;;
	 */
	
	public static int[][] map;
	public static int N;
	public static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.fill(map[N],N*N+1 );

		pipe(0,0,0);
		
		System.out.println(count);
	}

	private static void pipe(int x, int y, int dir) {
		
		if(dir == 0) { //가로
			if(y+2 < N &&  map[x][y+2] == 0) {
				if(x==N-1 && y+2==N-1) {
					count++;
					return;
				}
				pipe(x,y+1,0);
			}
			if(y+2 < N && x+1 < N&& map[x][y+2] == 0 && map[x+1][y+1] == 0 && map[x+1][y+2] == 0) {
				if(x+1==N-1 && y+2==N-1) {
					count++;
					return;
				}
				pipe(x,y+1,2);
			}
		}else if(dir == 1) { //세로
			if(x+2 < N &&  map[x+2][y] == 0){
				if(x+2==N-1 && y==N-1) {
					count++;
					return;
				}
				pipe(x+1,y,1);
			}
			if(x+2 < N && y+1<N && map[x+2][y] == 0 && map[x+1][y+1] == 0 && map[x+2][y+1] == 0){
				if(x+2==N-1 && y+1==N-1) {
					count++;
					return;
				}
				pipe(x+1,y,2);
			}
		}else if(dir == 2) { //대각선
			if(x+1 < N && y+2<N && map[x+1][y+2] == 0) {
				if(x+1==N-1 && y+2==N-1) {
					count++;
					return;
				}
				pipe(x+1,y+1,0);
			}
			
			if(x+2 < N && y+1<N && map[x+2][y+1] == 0) {
				if(x+2==N-1 && y+1==N-1) {
					count++;
					return;
				}
				pipe(x+1,y+1,1);
			}
			
			if(x+2 < N && y+2<N && map[x+1][y+2] == 0 && map[x+2][y+1] == 0 && map[x+2][y+2] == 0) {
				if(x+2==N-1 && y+2==N-1) {
					count++;
					return;
				}
				pipe(x+1,y+1,2);
			}
		}
	}
}
