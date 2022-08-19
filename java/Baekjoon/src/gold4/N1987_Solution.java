package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1987_Solution {
	static boolean[] alphabet;
	static char[][] map;
	static int[] dx;
	static int[] dy;
	static int r;
	static int c;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		alphabet = new boolean[26];
		dx = new int[] {-1,0,1,0};
		dy = new int[] {0,1,0,-1};
		
		for (int i = 0; i < r; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		move(0,0,1);
	
//		System.out.println(count);
		System.out.println(min);
		
	}

	private static void move(int x, int y, int count) {
		if(x<0 || x>=r || y<0 || y>=c) {
			return;
		}

//		System.out.print(map[x][y]+" : ");
//		System.out.print(count+" ");
//		System.out.println(Arrays.toString(alphabet));
		
		char a = map[x][y];
		if(alphabet[a-'A'] == false) {
			alphabet[a-'A'] = true;
			if(min<count)
				min = count;
		}else { // 이미 존재
			return;
		}
		for (int i = 0; i < 4; i++) {
			 move(x+dx[i],y+dy[i],count+1);
		}
		alphabet[a-'A'] = false;
	}
}
