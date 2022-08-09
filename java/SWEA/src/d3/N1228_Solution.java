package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class N1228_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int n = Integer.parseInt(in.readLine());
			boolean flag = true;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine()," ");
				if(flag) {
					String nodeNum = st.nextToken(); //중요하지 않음
					String rootNode = st.nextToken();
					if(st.countTokens() == 2) {		
						switch(rootNode) {
						case "+":
						case "-":
						case "*":
						case "/":
							break;
						default:
							flag = false;
							break;
						}
						
					}else {
						switch(rootNode) {
						case "+":
						case "-":
						case "*":
						case "/":
							flag = false;
							break;
						}
					}
				}
			}
			sb.append("#").append(test_case).append(" ");
			if(flag)
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");	
		}
		System.out.println(sb);
	}
}
