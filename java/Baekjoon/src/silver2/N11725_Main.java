package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N11725_Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		
		int[] result = new int[N+1];
		
		HashMap<Integer, String> map = new HashMap<>();
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			if(map.get(n1) == null) {
				map.put(n1, n2+"");
			}else {
				String prev = map.get(n1);
				map.put(n1, prev+" "+n2);
			}
			if(map.get(n2) == null) {
				map.put(n2, n1+"");
			}else {
				String prev = map.get(n2);
				map.put(n2, prev+" "+n1);
			}
		}
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {1});
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int root = arr[0];
//			System.out.println("root : "+root);
			if(map.get(root) == null)
				continue;
			st = new StringTokenizer(map.get(root), " ");
			while(st.countTokens()>0){
				int child = Integer.parseInt(st.nextToken());
//				System.out.println("child :"+child);
				if(result[child] == 0) {
					result[child] = root;
					queue.add(new int[] {child});
				}
			}
		}
		
		for (int i = 2; i <= N; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
	}



}
