package d2;

import java.util.Scanner;
public class N1959_Solution {


	public static void main(String args[]) throws Exception
	{
		Scanner input = new Scanner(System.in);
		int T;
		T=input.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = input.nextInt();
			int M = input.nextInt();
			int[] N_arr = new int[N];
			int[] M_arr = new int[M];
				
			for(int j=0; j<N; j++) {
				N_arr[j] = input.nextInt();
			}
			for(int j=0; j<M; j++) {
				M_arr[j] = input.nextInt();
			}
			
//			System.out.println(Arrays.toString(N_arr));
//			System.out.println(Arrays.toString(M_arr));
			
			int maxValue = 0;
			if(N>=M) {
				for(int j=0; j<N-M+1; j++) {
					int temp = 0;
					for(int k=0; k<M; k++) {
						temp += (N_arr[j+k]*M_arr[k]);
					}
					
					if(temp > maxValue) {
						maxValue = temp;
					}
					
				}
			}else {
				
				for(int j=0; j<M-N+1; j++) {
					int temp = 0;
					for(int k=0; k<N; k++) {
						temp += (N_arr[k]*M_arr[j+k]);
					}
					
					if(temp > maxValue) {
						maxValue = temp;
					}
					
				}
			}
			
			System.out.println("#" + test_case + " " + maxValue);
        }
	}
}