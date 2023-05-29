package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17247_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] xy = new int[4];
		int index = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				if(("1").equals(st.nextToken())) {
					xy[index++] = i;
					xy[index++] = j;
				}
			}
		}
		
		int x = Math.abs(xy[0] - xy[2]);
		int y = Math.abs(xy[1] - xy[3]);
		
		System.out.println(x+y);
	}

}
