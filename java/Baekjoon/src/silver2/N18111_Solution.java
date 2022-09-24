package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N18111_Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
				
		int time = 0;
		while(true) {
			int minValue = Integer.MAX_VALUE;
			int maxValue = Integer.MIN_VALUE;
			int minX = -1;
			int minY = -1;
			int maxX = -1;
			int maxY = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]>maxValue) {
						maxValue = map[i][j];
						maxX = i;
						maxY = j;
					}
					if(map[i][j]<minValue) {
						minValue = map[i][j];
						minX = i;
						minY = j;
					}
				}
			}
			
			if(minValue == maxValue) {
				break;
			}
			
//			System.out.println("~~ "+maxValue + " " + minValue);
//			for (int i = 0; i <N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			if(map[maxX][maxY]>0) {
				map[maxX][maxY]--;
				time++;
				B++;
			}else if(B>0) {
				map[minX][minY]++;
				time+=2;
				B--;
			}
		}

		System.out.println(time);
	}
}
