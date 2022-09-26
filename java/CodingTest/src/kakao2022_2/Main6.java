package kakao2022_2;

import java.util.LinkedList;
import java.util.Queue;

public class Main6 {

	public static int[] dx = {1,0,0,-1};
	public static int[] dy = {0,-1,1,0};
	public static int[][] map;

	public static void main(String[] args) {
		int n = 3;int m = 4;int x = 2;int y = 3;int r = 3;int c = 1;int k = 5;
		solution( n,  m,  x,  y,  r,  c,  k);
	}

	public static String solution(int n, int m, int x, int y, int r, int c, int k) {
		map = new int[n][m];
		x -= 1;y -= 1;
		r -= 1;c -=1;
		map[r][c] = 3;
		
//		String answer = "";
		return bfs(x,y,n,m,k);
	}

	public static String bfs(int a, int b, int n, int m, int k) {
		Queue<String[]> q = new LinkedList<>();
		q.offer(new String[] {a+"", b+"",0+"",""});

		while (!q.isEmpty()) {
			String[] arr = q.poll();
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);
			int nk = Integer.parseInt(arr[2])+1;
			System.out.println("x : "+x+" y : "+y);
			if (map[x][y] == 3 && nk==k) {
				return arr[3];
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {	
					String dir = arr[3];
					if(i==0) {
						q.offer(new String[] {nx+"", ny+"", nk+"",dir+"d"});
					}else if(i==1) {
						q.offer(new String[] {nx+"", ny+"",nk+"", dir+"l"});
						
					}else if(i==2) {
						q.offer(new String[] {nx+"", ny+"",nk+"", dir+"r"});
						
					}else if(i==3) {
						q.offer(new String[] {nx+"", ny+"", nk+"",dir+"u"});
						
					}
					
				}
			}
		}
		return "impossible";
	}
}
