package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class N1920_Solution {
	public static int[] arr;
	public static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		arr = new int[n];
		st = new StringTokenizer(in.readLine()," ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int m = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine()," ");
		for (int i = 0; i < m; i++) {
			int x = Integer.parseInt(st.nextToken());
			boolean flag = search(x);
			if(flag)
				sb.append("1").append("\n");
			else
				sb.append("0").append("\n");
//			System.out.println();
		}
		System.out.println(sb);
	}

	private static boolean search(int x) {
		int start = 0;
		int temp = n/2;
		int end = n-1;
		
		while(start <= end) {
//			System.out.println("start : "+start+ " temp : "+temp +" end : "+end);
			if(arr[temp] == x)
				return true;
			else if(arr[temp] > x) {
				end = temp-1;
				temp = (start+end)/2;
			}else {
				start = temp+1;
				temp = (start+end)/2;
			}
		}
		return false;
	}
}