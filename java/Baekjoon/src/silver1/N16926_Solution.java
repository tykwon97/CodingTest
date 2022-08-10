package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N16926_Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};

		for (int k = 0; k < r; k++) {
			for (int i = 0; i <= Math.min(n, m)/2; i++) {
				int prevx = i;
				int prevy = i;
				int prevValue = arr[prevx][prevy];
				int dir = 0;
				while(true) {
					if(dir == 4) {
						break;
					}
					int x = prevx + dx[dir];
					int y = prevy + dy[dir];

					if(x>=i && y>=i && x<n-i && y<m-i) {
						int value = arr[x][y];
						arr[x][y] = prevValue;
						prevValue = value;
						prevx = x;
						prevy = y;
					}else {
						dir += 1;
					}

				}

			}

		}

		for(int[] map : arr) {
			for(int x : map) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
