package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2805_Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int maxValue = Integer.MIN_VALUE;
		st = new StringTokenizer(in.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] > maxValue)
				maxValue = arr[i];
		}
		
		long start = 0;
		long end = maxValue;
		long pivot = (start+end)/2;
		
		long result = -1;
		
		while(start<=end) {
//			System.out.println("start : "+start + " end  : "+end+ " pivot : "+pivot);
			long total = 0;
			for (int i = 0; i < N; i++) {
				long temp = (arr[i] - pivot);
				if(temp>0)
					total += temp;
			}
//			System.out.println(" total : "+total);
			
			if(total >= M) {
				result = pivot;
				start = pivot+1;
				pivot = (start+end)/2;
				
			}else if (total < M) {
				end = pivot-1;
				if(end == 0)
					pivot = 0;
				else
					pivot = (start+end)/2;
			}
//			System.out.println("result : "+result);
			
		}
		System.out.println(result);
//		4 7
//		20 15 10 17

		
	}
}
