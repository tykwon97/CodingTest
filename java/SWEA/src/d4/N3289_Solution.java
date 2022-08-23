package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class N3289_Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testCase = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=testCase; tc++) {
			st = new StringTokenizer(in.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			String result = "";
			
			int[] rep = new int[n+1];
			for (int i = 0; i < rep.length; i++) {
				rep[i] = i;
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine()," ");
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				int r1 = a;
				while(rep[r1] != r1) {
					r1 = rep[r1];
				}
				
				int r2 = b;
				while(rep[r2] != r2) {
					r2 = rep[r2];
				}
				
				if(op == 0) { //합치기
					if(r1!=r2) {
						
						for (int j = 0; j < rep.length; j++) {
							if(rep[i] == rep[r2]) {
								rep[i] = rep[r1];
							}
						}
					}
					
					
				}else { // 판별하기
					if(r1==r2) {
						result += "1";
					}else {
						result += "0";
					}
				}
	
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}
}
