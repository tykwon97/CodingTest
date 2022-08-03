package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class N1620_Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] str = in.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {	
			String x = in.readLine();
			arr[i]=x;
			map.put(x, i+1);
		}
		
		for (int i = 0; i < m; i++) {
			String x = in.readLine();
			if(x.charAt(0) >= '0' && x.charAt(0) <= '9') {
				sb.append(arr[Integer.parseInt(x)-1]+"\n");
			}else {
				sb.append(map.get(x)+"\n");
			}
		}
				
		System.out.println(sb);
				
	}
}
