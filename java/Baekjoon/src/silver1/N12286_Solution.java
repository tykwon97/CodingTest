package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class N12286_Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(in.readLine());

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		HashMap<Integer,Integer> list = new HashMap<>();

		for (int i = 0; i < num; i++) {
			int n = Integer.parseInt(in.readLine());
			if(n == 0) {
				if(minHeap.isEmpty()) {
					sb.append("0");
				}else {
					int x = minHeap.poll();
					if(list.containsKey(-1*x) && list.get(-1*x) > 0) {
						if(list.get(-1*x) == 1) {
							list.remove(-1*x);
						}else {
							int y = list.get(-1*x);
							list.replace(-1*x, y, y-1);
						}
						x *= -1;
					}
					sb.append(x);
				}
				sb.append("\n");
			}else if(n>0) {
				minHeap.add(n);
			}else {
				if(list.containsKey(n)) {
					int x = list.get(n);
					list.replace(n, x, x+1);
				}else {
					list.put(n, 1);
				}
				
				minHeap.add(-1*n);
			}
		}
		System.out.println(sb);
	}
}
