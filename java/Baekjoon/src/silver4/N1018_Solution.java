package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class N1018_Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int min = Integer.MAX_VALUE;

		char[][] arr = new char	[n][m];
		for (int i = 0; i < n; i++) {
			arr[i] = in.readLine().toCharArray();
		}

		for (int i = 0; i <= n-8; i++) {
			for (int j = 0; j <= m-8; j++) {

				int value_1 = 0;
				int value_2 = 0;

				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						String x = String.valueOf(arr[i+k][j+l]);
//						System.out.println(x);
						if( (i+k+j+l)%2 == 0) {
							if(x.equals("W")) {
								value_1++;
							}else {
								value_2++;
							}
						}else {
							if(x.equals("W")) {
								value_2++;
							}else {
								value_1++;
							}
						}
					}
				}
//				System.out.println("value_1 : "+value_1+" value_2 : "+value_2);
				if(min>value_1)
					min = value_1;
				if(min>value_2)
					min = value_2;
//				System.out.println("min : "+min);
			}
		}


		System.out.println(min);

	}
}
