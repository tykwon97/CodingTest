package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class N2605_Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		List<Integer> list = new LinkedList<Integer>();
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		list.add(1);
		st.nextToken();
		for (int i = 2; i <= N; i++) {
			int x = Integer.parseInt(st.nextToken());
			list.add(i-x-1, i);
		}

		for(int x : list) {
			sb.append(x).append(" ");
		}
		System.out.println(sb);
	}
}

