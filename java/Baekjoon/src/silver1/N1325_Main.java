package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1325_Main {
	public static int N;
	public static int maxValue;
	public static List<Integer> list; //결과 저장
	public static List<Integer>[] map; // 신뢰 관계

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new List[N+1];
		for (int i = 0; i < N+1; i++) {
			map[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			map[B].add(A);
		}
		
		list = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
//			System.out.println(i+"번째");
			int result = BFS(i);
			if(maxValue<result) {
				maxValue = result;
				list = new LinkedList<>(); 
				list.add(i);
			}else if(maxValue == result){
				list.add(i);
			}
		}

//		System.out.println(Arrays.toString(DP));	
		for (int i : list) 
			sb.append(i).append(" ");
		
		System.out.println(sb);
	}

	private static int BFS(int start) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {start,1});
		
		boolean[] isSelected = new boolean[N+1];
		
		int value = -1;
		
		int[] DP = new int[N+1];
		Arrays.fill(DP, Integer.MIN_VALUE);
		
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int index = arr[0];
			int cnt = arr[1];
			
//			System.out.println("index : "+index+" cnt : "+cnt+" DP[index] : "+DP[index]);
			
			if(isSelected[index])
				continue;
			isSelected[index] = true;
			
			if(DP[index] > cnt) 
				continue;
			DP[index] = cnt;
			
			if(cnt>value) 
				value = cnt;
			
			List<Integer> newList = map[index];
			
//			System.out.println("==");
			
			for (int i  : newList) {
//				System.out.println("+++=");
				if(!isSelected[i]) 
					queue.add(new int[] {i,cnt+1});
			}
		
		}
		
		return value;
	}	
}
