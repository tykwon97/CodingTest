package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1873_Solution {

	public static int x = 0;
	public static int y = 0;

	private static void shoot(char[][] map, int x1, int y1, int dir, int H, int W) {
		int dx[] = {-1,0,1,0};
		int dy[] = {0,1,0,-1};
		
		int tempx = x1+dx[dir];
		int tempy = y1+dy[dir];
		while(tempx >= 0 && tempx<H && tempy>=0 && tempy<W) {
			if(map[tempx][tempy] == '#') {
				break;
			}else if(map[tempx][tempy] == '*'){
				map[tempx][tempy] = '.';
				break;
			}else {
				tempx = tempx+dx[dir];
				tempy = tempy+dy[dir];
			}
		}
		return;
	}

	private static void move(char[][] map, int x1, int y1, int dir, int H, int W) {
		char[] direction = {'^','>','v','<'};
		int dx[] = {-1,0,1,0};
		int dy[] = {0,1,0,-1};
		
		int tempx = x1+dx[dir];
		int tempy = y1+dy[dir];
		if(tempx >= 0 && tempx<H && tempy>=0 && tempy < W) {
			if(map[tempx][tempy] == '.') { //움직일 수 있는 경우
				map[tempx][tempy] = direction[dir];
				map[x][y] = '.';
				x = tempx;
				y = tempy;
			}
		}
		map[x][y] = direction[dir]; // 방향만 바꿔주기
		return;
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken()); 

			char[][] map = new char[H][W];

			int dir = -1;

			for (int j = 0; j < H; j++) {
				map[j] = in.readLine().toCharArray();
				for (int k = 0; k < W; k++) {
					if(map[j][k] == '^') {
						dir = 0;
					}else if(map[j][k] == '>') {
						dir = 1;
					}else if(map[j][k] == 'v') {
						dir = 2;
					}else if(map[j][k] == '<') {
						dir = 3;
					}else {
						continue;
					}
					x = j;
					y = k;
				}
			}

			int n = Integer.parseInt(in.readLine());
			char[] move = in.readLine().toCharArray();

			for(char m : move) {
				if(m == 'S') {
					shoot(map,x,y,dir,H,W);
				}else {
					if(m== 'U')
						dir = 0;
					else if(m== 'R')
						dir = 1;
					else if(m== 'D')
						dir = 2;
					else if(m== 'L')
						dir = 3;
					move(map,x,y,dir,H,W);
				}
			}

			sb.append("#"+i+" ");
			for(char[] arr : map) {
				for(char a : arr) {
					sb.append(a);
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);
	}
}
