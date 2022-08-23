package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N7465_Solution {

	public static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testCase = Integer.parseInt(in.readLine());

		for(int tc=1; tc<=testCase; tc++) {
			st = new StringTokenizer(in.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			p = new int[n+1];

			for (int i = 0; i < n+1; i++) {
				makeSet(i);
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				unionSet(a,b);
			}

			int count = 0;
			for (int i = 1; i < p.length; i++) {
				if(i == p[i])
					count++;
			}

			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}

		System.out.println(sb);
	}

	public static void makeSet(int i) {
		p[i] = i ;
	}

	public static int findSet(int x){
		if(p[x] == x)
			return x;
		else
			return p[x] = findSet(p[x]);
	}

	public static void unionSet(int x, int y){
		if(findSet(x) == findSet(y))
			return;
		p[findSet(y)] = findSet(x);
	}
}
