package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class N1218_Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();


		for(int tc=1; tc<=10; tc++) {
			int n = Integer.parseInt(in.readLine());
			char[] arr = in.readLine().toCharArray();
			int flag = 1;

			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < n; i++) {
				switch(arr[i]+"") {
				case "(" :
				case "[" :
				case "{" :
				case "<" :
					stack.push(arr[i]);
					break;

				case ")" :
					char x1 = stack.pop();
					if(x1 != '(')
						flag = 0;
					break;
				case "]" :
					char x2 = stack.pop();
					if(x2 != '[')
						flag = 0;
					break;
				case "}" :
					char x3 = stack.pop();
					if(x3 != '{')
						flag = 0;
					break;
				case ">" :
					char x4 = stack.pop();
					if(x4 != '<')
						flag = 0;
					break;

				}
				if(flag == 0)
					break;
			}
			sb.append("#").append(tc).append(" ").append(flag).append("\n");
		}

		System.out.println(sb);
	}
}
