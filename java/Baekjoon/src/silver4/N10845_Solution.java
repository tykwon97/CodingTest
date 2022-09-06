package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class N10845_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> queue = new LinkedList<Integer>();
		int num = Integer.parseInt(in.readLine());
		int lastNum = -1;
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			String op = st.nextToken();
			if(op.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				queue.offer(x);
				lastNum = x;
			}else if(op.equals("front")) {
				if(queue.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(queue.peek());
				}
			}else if(op.equals("back")) {
				if(queue.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(lastNum);
				}
			}else if(op.equals("size")) {
				System.out.println(queue.size());
			}else if(op.equals("empty")) {
				if(queue.isEmpty()) {
					System.out.println("1");
				}else {
					System.out.println("0");
				}
			}else if(op.equals("pop")) {
				if(queue.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(queue.poll());
				}
			}
		}
	}
}
