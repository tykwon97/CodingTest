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
			boolean[][] isSelected = new boolean[N][M];
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(in.readLine(), " ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				map[x][y] = true;
			}
			
			root = new int[N][M]; //초기화 작업
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(map[j][k])
						root[j][k] = j*M+k;
					else
						root[j][k] = N*M;
				}
			}
			
			int[] dx = {1,0,0,-1};
			int[] dy = {0,1,-1,0};
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if(map[x][y]) {
						for (int l = 0; l < 4; l++) {
							int newX = x+dx[l];
							int newY = y+dy[l];
							if(newX<0 || newY<0 || newX>=N || newY>=M)
								continue;
							if(map[newX][newY]) {
								isSelected[x][y] = true;
								if(!isSelected[newX][newY])
									make_set(x,y,newX,newY);
//								System.out.println("X : "+ x+" y : "+y+" nx : "+newX+" ny : "+ newY);
							}
						}
					}
				}
			}

			HashSet<Integer> set = new HashSet<>();
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
//					System.out.print(root[x][y]+" ");
					set.add(root[x][y]);
				}
			}
			int size = set.size()-1;
			if(size == 0)
				sb.append(set.size()).append("\n");
			else
				sb.append(set.size()-1).append("\n");
		}
		System.out.println(sb);
	}
	

	private static void make_set(int x1, int y1, int x2, int y2) {
		int parent1 = find(x1,y1);
		int parent2 = find(x2,y2);
//		System.out.println("X : "+ x1+" y : "+y1+" y1 : "+x2+" ny : "+ y2);
//		System.out.println("parnet 1 : "+parent1+"parent2 : "+parent2);
		if(parent1 == parent2) {
			return;
		}else {
			if(parent1> parent2)
				root[x1][y1] = parent2;
			else
				root[x2][y2] = parent1;
				
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
