package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N17626_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int[] lagrange = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			if(Math.sqrt(i)%1 == 0.0) { // 제곱수 인 경우
				lagrange[i] = 1;
				if(i+2 <= N) { // 제곱수 바로 앞 수 2개 미리 결정
					lagrange[i+1] = 2;
					lagrange[i+2] = 3;
				}
				if(i*2 <= N) // i^2 *2 로 이루어진 수
					lagrange[i*2] = 2;
				
				continue;
				
			}else {
				if(lagrange[i] == 0) {
					int temp = Integer.MAX_VALUE;
					int len = (i+1)/2;
					for (int j = len; j <= i-1; j++) {
						int value = lagrange[j] + lagrange[i-j];
//						System.out.println("i : "+i+" value : "+value+ " j : "+j+ " i-j : "+(i-j));
						if(temp > value) {
							temp = value;
							if(temp == 2) // 가장 좋은 경우 일 때 바로 종료
								break;
						}
					}
					lagrange[i] = temp;
				}
			}
		}
//		System.out.println(Arrays.toString(lagrange));
		System.out.println(lagrange[N]);
	}
}
