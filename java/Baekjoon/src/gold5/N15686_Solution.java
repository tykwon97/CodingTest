package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N15686_Solution {

	public static String[] strs;
	public static int l;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());


		strs = new String[c];
		
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < c; i++) {
			strs[i] = st.nextToken();
		}
		
		Arrays.sort(strs);
		
		perm(0,0,"");
		
		System.out.println(sb);
	}

	private static void perm(int cnt, int start, String result) {
		if(cnt == l) {
			int count1 = 0, count2 = 0;
			for (int i = 0; i < result.length(); i++) {
				char x = result.charAt(i);
				if(x == 97 || x == 101 || x == 105 || x == 111 || x == 117)
					count1++;
				else
					count2++;
				if(count1>= 1 && count2 >= 2) {
					sb.append(result).append("\n");
					break;
				}
			}
			return;
		}
		for (int i = start; i < strs.length; i++) {
			perm(cnt+1,i+1, result+strs[i]);
		}
	}
}
