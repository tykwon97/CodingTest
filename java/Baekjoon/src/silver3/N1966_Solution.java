package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
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

			PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[0]-b[0]) ;
			
			st = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < n; j++) {
				queue.offer(new int[] {Integer.parseInt(st.nextToken()), j});
			}
			
			for (int j = 0; j < n; j++) {
				int[] list = queue.poll();
				sb.append(Arrays.toString(list)).append("\n");
				int x = list[1];

//				System.out.println(x);
				if(m == x)
					sb.append(j+1).append("\n");
			}
		}
		System.out.println(sb);
	}
}
