package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1325_Main {
	public static int N;
	public static int maxValue;
	public static int[] hacking;
	public static List<Integer> list; //결과 저장
	public static List<List<Integer>> map; // 신뢰 관계

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[N+1];
		
		map = new LinkedList<>();
		for (int i = 0; i < N+1; i++) {
			List<Integer> nList = new LinkedList<>();
			map.add(nList);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			check[A] = true;
			check[B] = false;
			map.get(A).add(B);
		}

		list = new LinkedList<>();
		maxValue = Integer.MIN_VALUE;
		hacking = new int[N+1];
		Arrays.fill(hacking, Integer.MIN_VALUE);
		
		for (int i = 1; i <= N; i++) {
			if(!check[i])
				continue;
			BFS(i);
		}
		
		for (int i = 0; i < hacking.length; i++) {
			if(maxValue < hacking[i]) {
				maxValue = hacking[i];
				list = new LinkedList<>();
				list.add(i);
			}else if(maxValue == hacking[i]) {
				list.add(i);
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
	}

	private static void BFS(int i) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {i,1});
		
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int index = arr[0];
			int cnt = arr[1];
			
			if(hacking[index] >= cnt) 
				continue;
			
			hacking[index] = cnt;
			
			List<Integer> newList = map.get(index);
			for (int j = 0; j < newList.size(); j++) {
				int newIndex = newList.get(j);
				queue.add(new int[] {newIndex, cnt+1});
			}	
		}
	}
}
