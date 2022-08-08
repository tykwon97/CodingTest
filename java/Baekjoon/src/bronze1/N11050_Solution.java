package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11050_Solution {
	
	public static void main(String[] args) throws IOException {
		// 이항 계수는 주어진 크기의 세트에서 특정 수의 결과를 선택할 때 가능한 조합 수
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// nCk란?
		double total = 1;
		if(n/2 > k)
			k = n-k;
		for (int i = 0; i < k; i++) {
			total *= 1.0*(n-i)/(k-i);
		}
		
		System.out.println((int)Math.round(total));
	}

}
