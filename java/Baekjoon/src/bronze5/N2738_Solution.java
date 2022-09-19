package bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2738_Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine()," ");
				for (int j = 0; j < M; j++) {
					int x = Integer.parseInt(st.nextToken());
					arr[i][j] += x;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");				
			}
			System.out.println();
		}
	}
}
