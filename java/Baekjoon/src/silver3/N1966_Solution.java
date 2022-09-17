package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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

			Queue<int[]> queue = new ArrayDeque<>();
			PriorityQueue<Integer> pQueue = new PriorityQueue<>();
			
			st = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < n; j++) {
				int x = Integer.parseInt(st.nextToken());
				queue.offer(new int[] {x,j});
				pQueue.offer(-1*x);
			}
			
			int count = 0;
			int priority = -1 * pQueue.poll();
			while(true) {
				int[] arr = queue.poll();
				int nowPriority = arr[0];
				int index = arr[1];
//				System.out.println(priority+ " " + nowPriority + " " + index);
				if(nowPriority == priority) {
					if(index == m) {
						sb.append(count+1).append("\n");
						break;
					}
					priority = -1 * pQueue.poll();
					count++;
				}else {
					queue.add(new int[] {nowPriority,index});
				}
			}
			
		}
		System.out.println(sb);
	}
}
