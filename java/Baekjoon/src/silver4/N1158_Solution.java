package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class N1158_Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		
		sb.append("<");
		while(queue.size() != 0) {
			for (int i = 0; i < k-1; i++) {
				queue.offer(queue.poll());
			}
			if(queue.size() == 1)
				sb.append(queue.poll()).append(">");
			else
				sb.append(queue.poll()).append(", ");
		}
	
		System.out.println(sb);
				
	}
}
