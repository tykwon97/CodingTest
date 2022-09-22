package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N4949_Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			char[] strs = in.readLine().toCharArray();
			if(strs.length==1 && strs[0] == '.')
				break;
			
			Stack<Character> stack = new Stack<>();
			boolean flag = true;
			for (int i = 0; i < strs.length; i++) {
				if(strs[i] == '[' || strs[i] == '(') {
					stack.push(strs[i]);
				}else if(strs[i] == ']') {
					if(stack.isEmpty() || stack.pop() != '[') {
						flag = false;
						break;
					}
				}else if(strs[i] == ')') {
					if(stack.isEmpty() || stack.pop() != '(') {
						flag = false;
						break;
					}
				}
			}
			if(flag && stack.isEmpty())
				System.out.println("yes");
			else
				System.out.println("no");
		}
		
		
	}
}


