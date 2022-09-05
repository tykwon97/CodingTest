package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class N10818_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>();
		int num = Integer.parseInt(in.readLine());
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			String op = st.nextToken();
			if(op.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			}else if(op.equals("top")) {
				if(stack.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(stack.peek());
				}
			}else if(op.equals("size")) {
				System.out.println(stack.size());
			}else if(op.equals("empty")) {
				if(stack.isEmpty()) {
					System.out.println("1");
				}else {
					System.out.println("0");
				}
			}else if(op.equals("pop")) {
				if(stack.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(stack.pop());
				}
			}
		}
	}
}
