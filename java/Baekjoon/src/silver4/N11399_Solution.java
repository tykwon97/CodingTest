package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class N11399_Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < n; i++) {
			queue.offer(Integer.parseInt(st.nextToken()));
		}
		
		int total = 0;
		while(!queue.isEmpty())
			total += queue.poll()*n--;
		
		
	
		System.out.println(total);
				
	}
}
