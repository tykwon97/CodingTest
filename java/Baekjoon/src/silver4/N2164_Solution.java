package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class N2164_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(in.readLine());
		
//		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for(int i=1; i<= num; i++) {
			queue.add(i);
		}
		
		while(queue.size() != 1 ) {
			queue.poll();
			queue.add(queue.poll());
		}
		
		System.out.println(queue.poll());
		
	}
}
