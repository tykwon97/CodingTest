package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N1012_Main {
	public static int M;
	public static int N;
	public static int[][] root;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			boolean[][] map = new boolean[N][M];
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(in.readLine(), " ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				map[x][y] = true; // 배추 표시
			}

			root = new int[N][M]; //초기화 작업
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if(map[x][y]) // 배추있는 곳만 초기화
						root[x][y] = x*M+y;
					else
						root[x][y] = N*M;
				}
			}

			int[] dx = {1,0,0,-1};
			int[] dy = {0,1,-1,0};
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if(map[x][y]) { // 배추일때 (x,y)기준으로 4방탐색
						for (int l = 0; l < 4; l++) { 
							int newX = x+dx[l];
							int newY = y+dy[l];
							if(newX<0 || newY<0 || newX>=N || newY>=M) //범위 벗어난 경우
								continue;
							if(map[newX][newY]) { //탐색된 지역에 배추가 있는 경우 Union-Find
								make_set(x,y,newX,newY);
							}
						}
					}
				}
			}

			HashSet<Integer> set = new HashSet<>(); // Union-Find 개수 구하기
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if(map[x][y]) { //배추 있는 부분만
						int rootValue = find(x,y); // 루트 노드 찾기
						int rootX = rootValue/M;
						int rootY = rootValue%M;
						set.add(root[rootX][rootY]);
					}
				}
			}

			int size = set.size();
			sb.append(size).append("\n");
		}

		System.out.println(sb);
	}


	private static void make_set(int x1, int y1, int x2, int y2) {
		int parent1 = find(x1,y1);
		int parent2 = find(x2,y2);
		
		if(parent1 == parent2) {
			return;
		}else {
			root[parent1/M][parent1%M] = parent2; // 루트 노드만 변경
			find(x1,y1); // 루트 노드부터 차례대로 변경해주기
		}
	}

	private static int find(int x, int y) {
		int parent = root[x][y];
		if(parent == x*M+y) {
			return x*M+y;
		}else {
			int nextX = parent/M;
			int nextY = parent%M;
			return root[x][y] = find(nextX,nextY);
		}
	} 
}