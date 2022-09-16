package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1654_Solution {
	
	/*
	 * start를 0으로 시작하는 경우 temp에서 0이 되어 zero division이 발생 하는 문제가 있어 start를 1로 변경했다.
	 * start와 end를 더하는 과정에서도 integer 범위를 벗어나는 문제가 발생해 Long형으로 모두 바꿔주었다.
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		long start = 1;
		long end = Integer.MIN_VALUE;
		
		int[] arr = new int[k];
		for (int i = 0; i < k; i++) {
			int x = Integer.parseInt(in.readLine());
			arr[i] = x;
			if(x>end)
				end = x;
		}
		
		long temp = (start+end)/2;
		long result = Integer.MIN_VALUE;
//		System.out.println("start : "+start+"end : "+end +" result : "+result);
		while(start <= end) {
//			System.out.println("start : "+start+"end : "+end +" result : "+result);
			long count = 0;
			for (int i = 0; i < k; i++) {
				count += arr[i]/temp;
			}
//			System.out.println("count : "+count);
			
			if(count == n) {
				if(result < temp) {
					result = temp;
				}
				start = temp+1;
				temp = (start+end)/2;
			}else if(count < n) {
				end = temp-1;
				temp = (start+end)/2;
				
			}else if(count > n) {
				if(result < temp) {
					result = temp;
				}
				start = temp+1;
				temp = (start+end)/2;
			}
		}
		System.out.println(result);
		
	}
}
