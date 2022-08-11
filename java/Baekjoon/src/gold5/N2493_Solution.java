package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class N2493_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[n];
		result[0] = 0;
		
		List<Integer> list = new LinkedList<>();
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if(list.isEmpty())
				list.add(arr[i]);
			else {
				int len = list.size();
				if(list.get(len-1) < arr[i]) {
					
					while(!list.isEmpty() &&list.get(len-1) < arr[i]) {
						list.remove(len-1);
						len = list.size();
						cnt++;
					}
					if(list.isEmpty()) {
						cnt = 0;
						list.add(arr[i]);
						result[i] = 0;
					}else {
						
						list.add(arr[i]);
						System.out.println("i : "+i+" cnt : "+cnt);
						result[i] = i-cnt;
					}
					
				}else {
					list.add(arr[i]);
					result[i] = i;
				}
			}
		}
		
		for (int x : result) {
			sb.append(x).append(" ");
		} 
		System.out.println(sb);
	}
}


