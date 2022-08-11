package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class N7568_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 이게 맞나 싶어...
		
		int num = Integer.parseInt(in.readLine());
		
		int[] rank = new int[num];
		
		int[] arr = new int[num*2];
		
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i*2] = x;
			arr[i*2+1] = y;
		}
		
		for(int i = 0; i < num; i++) {
			int x1 = arr[i*2];
			int y1 = arr[i*2+1];
			for (int j = 0; j < num; j++) {
				if(i != j) {
					int x2 = arr[j*2];
					int y2 = arr[j*2+1];
					if(x1 > x2) {
						if(y1>y2) {
							rank[i] += 1;
						}
					}else {
						if(y2>y1) {
							rank[j] += 1; 
						}
					}
				}
			}
		}
			

		
		
		boolean[] isSelected = new boolean[num+1];
		for (int i = num; i >= 1; i--) {
			
			int minValue = Integer.MAX_VALUE;
			int minCount = 0;
			for (int j = 0; j < num; j++) {
				if(!isSelected[j]) {
					if(minValue == rank[j])
						minCount++;
					else if(minValue > rank[j]) {
						minValue = rank[j];
						minCount = 0;
					}
				}
			}
			
			i = i-minCount;
			
			for (int j = 0; j < num; j++) {
				if(rank[j] == minValue) {
					if(!isSelected[j]) {
						rank[j] = i;
						isSelected[j] = true;
					}
				}
			}
		}
		
		for(int x : rank) {
			sb.append(x).append(" ");
		}
		
		
		System.out.println(sb);
	}
}
