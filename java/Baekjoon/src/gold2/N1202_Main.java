package gold2;

import java.util.*;
import java.io.*;

public class N1202_Main {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> jewels = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
		    		 return o1[0] - o2[0];
		    	}else {
		    		return o2[1] - o1[1];
		    	}
			}
		});
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			jewels.add(new int[] {M,V});
		}
		
		List<Integer> bags = new LinkedList<>();
		for(int i=0; i<K; i++) {
			int C = Integer.parseInt(in.readLine());
			bags.add(C);
		}
		Collections.sort(bags);
		
		boolean[] isSelected = new boolean[bags.size()];
		
		int size = 0;																																										
		int total = 0;
		
		while(!jewels.isEmpty()) {
			int[] jewel = jewels.poll();
			int weight = jewel[0];
			int price = jewel[1];
//			System.out.println("weight : "+weight + " price : "+price);
			
			if(size == bags.size())
				break;
			
			for (int i = 0; i < bags.size(); i++) {
				if(isSelected[i])
					continue;
				if(bags.get(i) >= weight) {
//					System.out.println("price : "+price);
					total += price;
					isSelected[i] = true;
					size++;
					break;
				}
			}
		}
		
		System.out.println(total);
	}
}	