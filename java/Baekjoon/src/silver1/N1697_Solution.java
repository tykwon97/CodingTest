package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1697_Solution {
	
	/*
	 *  0번째 처리 하는 것을 까먹고 못 해서 오래 걸림..ㅜ
	 */
	
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int max = Math.max(n, k);
		
		arr = new int [max+2]; // max+1 한 곳에서 -1 한 값이 최소 일 수도 있으므로
 		for (int i = 0; i < max+2; i++) {
			arr[i] = Integer.MAX_VALUE-1;
		}
		
		arr[n] = 0;

		if(n >= k) {
			System.out.println(n-k);
		}else {
			for (int i = n-1; i >= 0; i--) {
				arr[i] = arr[i+1]+1;
			}
			
			for (int i = 1; i < max+2; i++) {
				if(i-1>=0)
					arr[i] = Math.min(arr[i-1]+1,arr[i]);
				if(i+1<max+2)
					arr[i] = Math.min(arr[i+1]+1,arr[i]);
				if(i*2<max+2) 
					arr[i*2] = Math.min(arr[i*2],arr[i]+1);
			}
			System.out.println(arr[k]);
		}
	}
}
