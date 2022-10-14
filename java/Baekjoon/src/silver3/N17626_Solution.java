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
			}else {
<<<<<<< HEAD
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
=======
				lagrange[i] = Integer.MAX_VALUE; // 초기화
				
				int len = (int)Math.sqrt(i);

				for (int j = 1; j<=len; j++) {
					// 자기 자신에서 가능한 제곱수들 뺀 나머지 DP배열 값을 비교해서 최소값..
					lagrange[i] = Math.min(lagrange[i], lagrange[i-j*j] + 1);
					
					if(lagrange[i] == 2) // 가장 좋은 경우 일 때 바로 종료
						break;
				}
			}
		}

>>>>>>> aa67b2c10ad4e16cb7c2e5dcd215b1aac4086ee4
		System.out.println(lagrange[N]);
	}
}
