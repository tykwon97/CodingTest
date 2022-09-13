package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class N10816_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		HashMap<Integer, Integer>map = new HashMap<>();
		int num = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine()," ");
		for (int i = 0; i < num; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(map.containsKey(x)) {
				map.replace(x, map.get(x)+1);
			}else {
				map.put(x, 1);
			}
		}
		
		num = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine()," ");
		for (int i = 0; i < num; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(map.containsKey(x)) {
				sb.append(map.get(x)).append(" ");
			}else {
				sb.append("0").append(" ");
			}
		}	
		System.out.println(sb);
		
	}
}
