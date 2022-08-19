package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class N3234_Solution {

	public static int num;
	public static int count;
	public static int[] arr;
	public static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=testCase; tc++) {
			num = Integer.parseInt(in.readLine());
			arr = new int[num];
			count = 0;
			int total = 0;
			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < num; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				total += arr[i];
			}
			
			isSelected = new boolean[num];
			
			scale(0,0,total);
			
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}

	private static void scale(int totalLeft, int totalRight, int total) {
		if(total == 0) {
			if(totalLeft >= totalRight) 
				count++;
			return;
		}
		else {
			if(totalLeft < totalRight || totalLeft + total < totalRight) {	
				return;
			}
		}

	
		for (int i = 0; i < num; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				scale(totalLeft+arr[i],totalRight,total-arr[i]);
				scale(totalLeft,totalRight+arr[i],total-arr[i]);
				isSelected[i] = false;
			}
		}
	}
	
	
}
