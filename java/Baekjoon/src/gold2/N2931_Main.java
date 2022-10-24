package gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2931_Main {
	public static int R;
	public static int C;
	public static int roadX;
	public static int roadY;
	public static String operation;
	public static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;


		st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C]; // 통로

		int[] spot = new int[4];
		int index = 0; //spot에 저장할 위치

		for (int j = 0; j < R; j++) { // 통로 입력받기
			map[j] = in.readLine().toCharArray();
		}

		for (int j = 0; j < R; j++) {
			for (int k = 0; k < C; k++) {
				if('M'==map[j][k] || 'Z'==map[j][k]){ // 집과 유치원 위치 x,y순서로 저장
					spot[index++] = j;
					spot[index++] = k;
				}
			}
		}

		// 지워진 위치
		roadX = -1;
		roadY = -1;
		// 지워진 그림
		operation = "$";

		for (int j = 0; j < 2; j++) {
			bfs(spot[j*2],spot[j*2+1]);
		}

		sb.append(roadX+1).append(" ").append(roadY+1).append(" ").append(operation).append("\n");

		System.out.println(sb);
	}

	private static void bfs(int startX, int startY) {
		Queue<int[]> queue = new ArrayDeque<>();

		boolean[][] isSelected = new boolean[R][C];
		isSelected[startX][startY] = true; // 이중 방문 예방

		int[] dx = {+1,+0,-1,+0};
		int[] dy = {+0,+1,+0,-1};

		//출발 위치에서 갈 수 있는 곳
		for (int i = 0; i < 4; i++) { 
			int nx = startX+dx[i];
			int ny = startY+dy[i];
			if(nx<0 || ny<0 || nx>=R || ny>=C) //범위를 벗어난 경우
				continue;
			if(map[nx][ny] == '.') //통로가 없는 경우
				continue;
			//			System.out.println("nx : "+nx+" ny : "+ny);
			queue.add(new int[] {nx,ny,startX,startY});
		}

		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			int x = xy[0];
			int y = xy[1];
			int prevx = xy[2];
			int prevy = xy[3];
			//			System.out.println("x : "+x +" y : "+y);
			if(isSelected[x][y]) //이미 방문한 경우
				continue;
			isSelected[x][y] = true;

			char op = map[x][y];
			System.out.println(" x: "+x +" y: "+y+"  prevx : "+prevx+" prevy : "+prevy);
			switch (op+"") {
			case ".":
				map[x][y] = '#'; //방문 처리
				break;
			case "|":
				if(prevx == x-1 && x+1<R)
					queue.add(new int[] {x+1,y,x,y});
				if(prevx == x+1 && x-1>=0)
					queue.add(new int[] {x-1,y,x,y});
				break;
			case "-":
				if(prevy == y-1 && y+1<C)
					queue.add(new int[] {x,y+1,x,y});
				if(prevy == y+1 && y-1>=0)
					queue.add(new int[] {x,y-1,x,y});
				break;
			case "+":
				if(prevx == x-1 && x+1<R)
					queue.add(new int[] {x+1,y,x,y});
				if(prevx == x+1 && x-1>=0)
					queue.add(new int[] {x-1,y,x,y});
				if(prevy == y-1 && y+1<C)
					queue.add(new int[] {x,y+1,x,y});
				if(prevy == y+1 && y-1>=0)
					queue.add(new int[] {x,y-1,x,y});
				break;
			case "1":
				if(prevy == y+1 && x+1<R && y>=0)
					queue.add(new int[] {x+1,y,x,y});
				if(prevx == x+1 && x>=0 && y+1<C) 
					queue.add(new int[] {x,y+1,x,y});
				break;
			case "3":
				//				System.out.println("prevx : "+prevx+" prevy : "+prevy +" x: "+x +" y: "+y);
				if(prevy == y-1 && x+1<R && y>=0)
					queue.add(new int[] {x+1,y,x,y});
				if(prevx == x-1 && x>=0 && y+1<C)
					queue.add(new int[] {x,y+1,x,y});
				break;
			case "2":
				if(prevx == x-1 && x<R && y+1<C)
					queue.add(new int[] {x,y+1,x,y});
				if(prevy == y-1 && x-1>=0 && y>=0)
					queue.add(new int[] {x-1,y,x,y});
				break;
			case "4":
				if(prevy == y+1 && x+1<R && y<C)
					queue.add(new int[] {x+1,y,x,y});
				if(prevx == x+1 && x>=0 && y-1>=0)
					queue.add(new int[] {x,y-1,x,y});
				break;
			default: // 출발지에서 방문한 지역 중 도착지에서도 방문한 경우 ('#')
				// 지워진 위치 저장
				roadX = x;
				roadY = y;
				System.out.println("x : "+x+" y : "+y);
				System.out.println();
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						System.out.print(map[i][j]+" ");
					}System.out.println();
				}
				// 통로가 연결될 위치 확인
				boolean[] spotCheck = new boolean[4]; //위 오 아 왼

				for (int i = 0; i < 4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if(nx<0 || ny<0 || nx>=R || ny>=C)
						continue;
					if((map[nx][ny]=='#') || (map[nx][ny]=='.')) { // 통로가 아닌 경우
						continue;
					}
					spotCheck[i] = true; // 연결 할 통로가 있는 경우
				}
				// 알맞은 통로 찾기
				if(spotCheck[0] && spotCheck[1])
					operation = "2";
				else if(spotCheck[0] && spotCheck[2])
					operation = "|";
				else if(spotCheck[0] && spotCheck[3])
					operation = "3";
				else if(spotCheck[1] && spotCheck[2])
					operation = "1";
				else if(spotCheck[1] && spotCheck[3])
					operation = "-";
				else if(spotCheck[2] && spotCheck[3])
					operation = "4";

				return;
			}
		}

		System.out.println();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}


	}
}
