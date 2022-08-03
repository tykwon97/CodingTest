package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N11723_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(in.readLine());

		HashSet<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			String op = st.nextToken();
			if(op.equals("all")) {
				set.clear();
				for(int j=1; j<=20; j++) {
					set.add(j);
				}
			}else if(op.equals("empty")) {
				set.clear();
			}else{
				int x = Integer.parseInt(st.nextToken());
				if(op.equals("add")) {
					set.add(x);
				}else if(op.equals("check")) {
					if(set.contains(x))
						sb.append("1\n");
					else
						sb.append("0\n");
				}else if(op.equals("toggle")) {
					if(set.contains(x))
						set.remove(x);
					else
						set.add(x);
				}else if(op.equals("remove")) {
					set.remove(x);
				}
			}
		}

		System.out.println(sb);
	}
}
