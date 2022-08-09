package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2563_Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		boolean[][] map = new boolean[100][100];
		
		int num = Integer.parseInt(in.readLine());
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					map[x+j][y+k] = true;
				}
			}
		}
		
		int cnt = 0;
		for (int j = 0; j < 100; j++) {
			for (int k = 0; k < 100; k++) {
				if(map[j][k] == true)
					cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
