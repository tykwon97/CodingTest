package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1238_Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc=1; tc<=10; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < n/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
			}


			

			sb.append("#").append(tc).append(" ").append("").append("\n");
		}

		System.out.println(sb);
	}

	
}
