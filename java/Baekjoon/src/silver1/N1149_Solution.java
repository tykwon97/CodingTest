package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1149_Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int minValue = Integer.MAX_VALUE;
		
		int[][] map = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] result = new int[N][3];
		result[0][0] = map[0][0];
		result[0][1] = map[0][1];
		result[0][2] = map[0][2];
		
	
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if(j==0) 
					result[i][j] = Math.min(map[i][j] + result[i-1][1], map[i][j] + result[i-1][2]);
				else if(j==1)
					result[i][j] = Math.min(map[i][j] + result[i-1][0], map[i][j] + result[i-1][2]);
				else if(j==2)
					result[i][j] = Math.min(map[i][j] + result[i-1][0], map[i][j] + result[i-1][1]);
			}
		}
		
		minValue = Math.min(result[N-1][0], result[N-1][1]);
		minValue = Math.min(minValue, result[N-1][2]);
		
		System.out.println(minValue);
	}
}
