package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2869_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		int count = 0;
		if(v>a) {
			v = v-a;
			if(v<(a-b))
				count = 1;
			else {
				count = (v)/(a-b);
				if(v%(a-b) != 0)
					count++;
			}
			
			
		}
		
		
		sb.append(count+1);
		
		System.out.println(sb);
	}
}
