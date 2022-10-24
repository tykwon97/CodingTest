package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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

		List<List<Integer>> list = new LinkedList<>();
		for (int i = 0; i <= N; i++) {
			List<Integer> newList = new LinkedList<>();
			list.add(newList);
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			list.get(n1).add(n2);
			list.get(n2).add(n1);
		}
		
		int[] result = new int[N+1];
		boolean[] isSelected = new boolean[N+1];
		
		// BFS
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(1);
		while(!queue.isEmpty()) {
			int index = queue.poll();
			if(isSelected[index])
				continue;
			isSelected[index] = true;
			List<Integer> newList = list.get(index);
			for (int i = 0; i < newList.size(); i++) {
				int newIndex = newList.get(i);
				if(!isSelected[newIndex]) {
					result[newIndex] = index;
					queue.add(newIndex);					
				}
				
			}
		}
		
		for (int i = 2; i <= N; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
	}

}
