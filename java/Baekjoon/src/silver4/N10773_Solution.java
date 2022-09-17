package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class N10773_Solution {
	
	/*
	 * Stack을 사용하지 않고 배열을 만들어 배열의 index의 값을 조정하며 덮어쓰기를 통해 속도를 높일 수 있다!
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(in.readLine());
			if(x==0) {
				stack.pop();
			}else{
				stack.push(x);
			}
		}
		
		int result = 0;
		while(!stack.isEmpty()) {
			result += stack.pop();
		}
		 
		System.out.println(result);
		
	}
}
