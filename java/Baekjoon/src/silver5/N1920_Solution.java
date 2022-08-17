package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1920_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		int[] arr1 = new int[n];
		st = new StringTokenizer(in.readLine()," ");
		for (int i = 0; i < n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1); // 작은 것부터 큰 순으로
		
		int pivot = 0;
		
		int m = Integer.parseInt(in.readLine());
		int[] arr2 = new int[n];
		st = new StringTokenizer(in.readLine()," ");
		for (int i = 0; i < n; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr2); // 작은 것부터 큰 순으로
		
		System.out.println(sb);
	}
}

//
//boolean flag = true;
//for(int j=pivot; j<n; j++) {
//	if(arr[j]==x) {
//		flag = false;
//		
//	}
//}
//
//if(flag)
//	sb.append("0").append("\n");
//else
//	sb.append("1").append("\n");