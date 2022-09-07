package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class N10866_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		int num = Integer.parseInt(in.readLine());
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			String op = st.nextToken();
			if(op.equals("push_front")) {
				int x = Integer.parseInt(st.nextToken());
				queue.addFirst(x);
			}else if(op.equals("push_back")) {
				int x = Integer.parseInt(st.nextToken());
				queue.addLast(x);
			}else if(op.equals("front")) {
				if(queue.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(queue.getFirst());
				}
			}else if(op.equals("back")) {
				if(queue.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(queue.getLast());
				}
			}else if(op.equals("size")) {
				System.out.println(queue.size());
			}else if(op.equals("empty")) {
				if(queue.isEmpty()) {
					System.out.println("1");
				}else {
					System.out.println("0");
				}
			}else if(op.equals("pop_front")) {
				if(queue.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(queue.pollFirst());
				}
			}else if(op.equals("pop_back")) {
				if(queue.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(queue.pollLast());
				}
			}
		}
	}
}
