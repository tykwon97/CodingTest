package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1987_Solution {

	public static class Node{
		int start;
		int to;
		int weight;
		Node(int start, int to, int weight){
			this.start = start;
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static Node[] list;
	public static int[] D;
	public static int V;
	public static int E;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(in.readLine());
		list = new Node[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[i] = new Node(u,v,w);
		}
		
		D = new int[V+1];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[start] = 0;
		
		Dijkstra(start);
		
		
	}
	private static void Dijkstra(int start) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((x,y)->x[1]-y[1]);
		queue.offer(new int[] {start,0});
		
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int startIndex = node[0];
			if(node[1] > D[startIndex])
				continue;
			for (int i = 0; i < E ; i++) {
				if(list[i].start == startIndex) {
					if(D[list[i].to] > list[i].weight + D[list[i].start]) {
						D[list[i].to] = list[i].weight + D[list[i].start];
						queue.add(new int[] {list[i].to,D[list[i].to]});
					}
				}
			}
//			System.out.print("queue : ");
//			for(int x : queue) {
//
//				System.out.print(x+" ");
//			}System.out.println();
		}
		for (int i = 1; i < D.length; i++) {
			if(D[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(D[i]);
		}
	}

	
}
