package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1697_Solution2 {
	
	/*
	 *  BFS로 한번 풀어보기
	 */
	
	public static int k;
	public static int n;
	public static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		if(n>=k)
			System.out.println(n-k);
		else {
			isVisited = new boolean[2*k+1];
			bfs(n);
		}
	}

	private static void bfs(int start) {
	
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {start,0});
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int index = node[0];
			int count = node[1];
			if(index<0 || index>=2*k+1)
				continue;
			
			if(isVisited[index])
				continue;
		
			isVisited[index] = true;
			if(index==k) {
				System.out.println(count);
				return;
			}
			
			queue.offer(new int[] {index*2,count+1});
			queue.offer(new int[] {index+1,count+1});
			queue.offer(new int[] {index-1,count+1});
			
		}
	}
}
