package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1546_Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		int[] arr = new int[num];
		int total = 0;
		int max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] > max) {
				max = arr[i];
			}
			total += arr[i];
		}
		
		System.out.println(1.0*total/max*100/num);

	}

}
