package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N17626_Solution2 {
	public static int[] count;
	public static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		count = new int[N+1];

		System.out.println(lagrange(N));
//		System.out.println(Arrays.toString(count));
	}

	private static int lagrange(int i) {
		if(count[i] == 0) {
			if(Math.sqrt(i)%1 == 0.0) { // 제곱수 인 경우
				count[i] = 1;
				if(i+2 <= N) { // 제곱수 바로 앞 수 2개 미리 결정
					count[i+1] = 2;
					count[i+2] = 3;
				}
				if(i*2 <= N) // i^2 *2 로 이루어진 수
					count[i*2] = 2;

				return count[i];

			}else {
				int temp = Integer.MAX_VALUE;
				int len = (i+1)/2;
				for (int j = i-1; j >= len; j--) {

					int x = lagrange(j);
					if(temp <= x) {
						continue;
					}
					int y = lagrange(i-j);
					if(temp <= y) {
						continue;
					}
					int value = x + y;
					if(temp > value) {
						temp = value;
						if(temp == 2) // 가장 좋은 경우 일 때 바로 종료
							break;
					}
				}
				count[i] = temp;
				return count[i];
			}
			
		}else {
			return count[i];
		}

	}
}
