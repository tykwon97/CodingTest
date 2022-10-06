package gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1194_Solution {
	
	public static int N;
	public static int M;
	public static char[][] map;
	static int minMove = Integer.MAX_VALUE;
	public static boolean[][][] visited;
	public static int dx[] = {1,0,0,-1};
	public static int dy[] = {0,1,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M][64];
		
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
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		queue.offer(new int[]{sx,sy,0,0});
		visited[sx][sy][0] = true;
		map[sx][sy] = '.';
		
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int x = arr[0];
			int y = arr[1];
			int count = arr[2];
			int flag = arr[3];
			
//			System.out.println(Arrays.toString(map[0]));
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny][flag])
					continue;

//				System.out.println("x : "+ nx +" y : "+ny+" count : "+count);
				
				if(map[nx][ny] == '.') {
					queue.offer(new int[]{nx,ny,count+1, flag});
					visited[nx][ny][flag] = true;
				}else if('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
					
					//비트마스킹
					int keyNum = map[nx][ny] - 'a'; // 키 번호, a부터 0번
					int newKey = flag | (1 << keyNum); // 다음 위치 키와 현재 키 비트 마스킹
					if(!visited[nx][ny][newKey]) { // 새로운 키로 방문한 적이 없는 경우
						queue.offer(new int[] {nx, ny, count+1, newKey});
						visited[nx][ny][newKey] = true;
					}
					
				}else if('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
					
					int doorNum = map[nx][ny] - 'A'; // 문 번호, A부터 0번
					int hasKey = flag & (1 << doorNum); // 다음 위치 문과 가지고 있는 키 마스킹 체크
					
					if(hasKey > 0) { // 문에 대응되는 키를 가지고 있는 경우 -> 이동 가능
						queue.offer(new int[] {nx, ny, count+1, flag});
						visited[nx][ny][flag] = true;
					}
					
				}else if(map[nx][ny] == '1') {
					minMove = ((count+1) < minMove) ? (count+1) : minMove;
				}
			}
		}
		if(minMove == Integer.MAX_VALUE) {
			System.out.println("-1");			
		}else {
			System.out.println(minMove);
		}
		return;
	}
}
