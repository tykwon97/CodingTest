package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class N17144_Solution {

	public static int airCleanerX;
	public static int[][] map1;
	public static int[][] map2;
	public static int[] dx = {0,-1,0, 1,0,1,0, -1};
	public static int[] dy = {1,0,-1,0,1,0,-1,0};
	public static int R;
	public static int C;
	public static boolean[][] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		map1 = new int[R][C];
		map2 = new int[R][C];
		boolean flag = true;
		airCleanerX = 0;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < C; j++) {
				map1[i][j] = Integer.parseInt(st.nextToken());
				if(map1[i][j] == -1) {
					airCleanerX = i;
				}
			}
		}

		for (int i = 0; i < T; i++) { // T초 반복
			if(flag) {
				map2[airCleanerX-1][0] = -1;
				map2[airCleanerX][0] = -1;
			}else {
				map1[airCleanerX-1][0] = -1;
				map1[airCleanerX][0] = -1;
			}

			// 먼지 확산
			for (int x = 0; x < R; x++) {
				for (int y = 0; y < C; y++) {

					if(flag) { //flag가 true
						if(map1[x][y] != 0 && map1[x][y]!= -1) { //먼지 인 경우
							int count = 0;
							for (int l = 0; l < 4; l++) { //사방탐색
								int nextX = x+dx[l];
								int nextY = y+dy[l];
								if(nextX<0 || nextX >= R || nextY<0 || nextY>=C)
									continue;
								if(map1[nextX][nextY] == -1)
									continue;
								else {
									count++; //퍼트릴수 있는지
									map2[nextX][nextY] += map1[x][y]/5;
								}
							}
							map2[x][y] += map1[x][y]-(int)(map1[x][y]/5)*count;
						}

					}else { //flag가 false
						if(map2[x][y] != 0 && map2[x][y]!= -1) { //먼지 인 경우
							int count = 0;
							for (int l = 0; l < 4; l++) { //사방탐색
								int nextX = x+dx[l];
								int nextY = y+dy[l];
								if(nextX<0 || nextX >= R || nextY<0 || nextY>=C)
									continue;
								if(map2[nextX][nextY] == -1)
									continue;
								else {
									count++; //퍼트릴수 있는지
									map1[nextX][nextY] += map2[x][y]/5;
								}
							}
							map1[x][y] += map2[x][y]-(int)(map2[x][y]/5)*count;
						}
					} 
				}
			}

			isSelected = new boolean[R][C];
			for (int j = 1; j < airCleanerX-1; j++) {
				for (int k = 1; k < C-1; k++) {
					isSelected[j][k] = true;
				}
			}
			for (int j = airCleanerX+1; j < R-1; j++) {
				for (int k = 1; k < C-1; k++) {
					isSelected[j][k] = true;
				}
			}

			// 공기청정기 순환
			dfs1(airCleanerX-1,0,0,flag);
			dfs2(airCleanerX,0,0,flag);


			if(flag)
				map1 = new int[R][C];
			else
				map2 = new int[R][C];

			flag = !flag;
		}

		int total = 0;
		if(flag) {
			for(int[] arr : map1) {
				for(int x : arr) {
					total+=x;
				}
			}
		}else {
			for(int[] arr : map2) {
				for(int x : arr) {
					total+=x;
				}
			}
		}
		System.out.println(total+2);
	}



	private static void dfs1(int x, int y,int prevValue, boolean type) {
		if(x==airCleanerX-2 && y==0) {
			if(type) {
				map2[x][y] = prevValue;
			}else {
				map1[x][y] = prevValue;
			}
			return;
		}
		if(x<0 || x > airCleanerX || y<0 || y>=C) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];

			if(nextX <0 || nextY < 0 || nextX>airCleanerX-1 || nextY >= C) {
				continue;
			}
			if(isSelected[nextX][nextY]) {
				continue;
			}
			isSelected[nextX][nextY] = true;

			int nowValue = -1;
			if(type) {
				nowValue = map2[x][y];
			}else {

				nowValue = map1[x][y];
			}

			if(nowValue == -1) {
				nowValue = 0;
				prevValue = -1;
			}

			if(type) {
				map2[x][y] = prevValue;
			}else {

				map1[x][y] = prevValue;
			}

			dfs1(nextX,nextY,nowValue,type);
		}



	}

	private static void dfs2(int x, int y,int prevValue, boolean type) {
		if(x==airCleanerX-2 && y==0) {
			if(type) {

				map2[x][y] = prevValue;
			}else {
				map1[x][y] = prevValue;
			}
			return;
		}
		if(x<airCleanerX || x>=R || y<0 || y>=C)
			return;


		for (int i = 4; i < 8; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];

			if(nextX <airCleanerX || nextY < 0 || nextX>=R || nextY >= C) {
				continue;
			}
			if(isSelected[nextX][nextY]) {
				continue;
			}
			isSelected[nextX][nextY] = true;

			int nowValue = -1;
			if(type) {
				nowValue = map2[x][y];
			}else {
				nowValue = map1[x][y];
			}

			if(nowValue == -1) {
				nowValue = 0;
				prevValue = -1;
			}

			if(type) {
				map2[x][y] = prevValue;
			}else {

				map1[x][y] = prevValue;
			}

			dfs2(nextX,nextY,nowValue,type);
		}
	}
}
