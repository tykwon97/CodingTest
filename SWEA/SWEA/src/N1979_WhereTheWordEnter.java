import java.util.Scanner;

public class N1979_WhereTheWordEnter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{

			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) 
					arr[i][j] = sc.nextInt();
			}

			int count = 0;
			int pivot_row = 0;
			int pivot_cloumn = 0;

			for(int i=0; i<N; i++) {
				pivot_row = 0;
				pivot_cloumn = 0;
				for(int j=0; j<N; j++) {
					if(arr[i][j] == 1) 
						pivot_row++;
					else {
						if(pivot_row == K) 
							count += 1;
						pivot_row = 0;
					}

					if(arr[j][i] == 1) 
						pivot_cloumn++;
					else {
						if(pivot_cloumn == K) 
							count += 1;
						pivot_cloumn = 0;
					}

				}
				if(pivot_row == K) 
					count += 1;
				if(pivot_cloumn == K) 
					count += 1;

			}
			System.out.println("#" + test_case + " " + count);
		}
	}

}
