package gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1194_Solution {
	
	public static int N;
	public static int M;
	public static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		int sx=-1, sy=-1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == '0') {
					sx = i;
					sy = j;
				}
			}
		}
		
		miro(sx,sy);
	}

	private static void miro(int sx, int sy) {
		int dx[] = {1,0,0,-1};
		int dy[] = {0,1,-1,0};
		
		List<Character> key = new LinkedList<>();
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{sx,sy,0});
		map[sx][sy] = '.';
		
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int x = arr[0];
			int y = arr[1];
			int count = arr[2];
			System.out.println(Arrays.toString(map[0]));
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M)
					continue;

				System.out.println("x : "+ nx +" y : "+ny+" count : "+count);
				if(map[nx][ny] == '.') {
					queue.offer(new int[]{nx,ny,count+1});
				}else if('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
					System.out.println("kk?");
					if(!key.contains(map[nx][ny])) {
						key.add(map[nx][ny]);
					}
					queue.offer(new int[]{nx,ny,count+1});
				}else if('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
					char op = (char) (map[nx][ny]+32);
					if(key.contains(op)) {
						queue.offer(new int[]{nx,ny,count+1});
					}
				}else if(map[nx][ny] == '1') {
					System.out.println("count : "+count);
					return;
				}
			}
		}
		System.out.println("-1");
		return;
	}
}
