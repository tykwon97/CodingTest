package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1966_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
//			System.out.println(i+"번");
			st = new StringTokenizer(in.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			Queue<Integer> queue = new ArrayDeque<>();
			
			st = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < n; j++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			for (int j = 0; j < n; j++) {
				int x = queue.poll();

//				System.out.println(x);
				if(m == x)
					sb.append(j+1).append("\n");
			}
		}
		System.out.println(sb);
	}
}
