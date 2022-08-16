package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2798_Solution {
	
	public static int[] arr;
	public static int n;
	public static int m;
	public static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		st = new StringTokenizer(in.readLine()," ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 재귀로 풀어보기
		comb(0,0,0);
		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = i+1; j < arr.length; j++) {
//				for (int k = j+1; k < arr.length; k++) {
//					int total = arr[i] + arr[j] + arr[k];
//					if(m >= total && (m-min) > (m-total)) {
//						
//						min = total;
//					}
//				}
//			}
//		}
		
		System.out.println(min);
	}

	private static void comb(int total, int count, int index) {
		
		if(total>m) return;
		if(count == 3) {
			if(m >= total && total > min) {
				min = total;
			}
			return;
		}
		
		for (int i = index; i < n; i++) {
			comb(total+arr[i], count+1, i+1);
		}
		
	}
}

