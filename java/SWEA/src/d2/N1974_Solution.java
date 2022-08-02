package d2;

import java.util.Scanner;
public class N1974_Solution {

	public static void main(String args[]) throws Exception
	{
		Scanner input = new Scanner(System.in);
		int T;
		T=input.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[][] map = new int[9][9];
			int sudoku = 1;
			for(int i=0; i<9; i++) {
				for (int j = 0; j <9; j++) {
					map[i][j] = input.nextInt();
				}
			}

			for(int i=0; i<9; i++) {

				int[] flag = {0,0,0,0,0,0,0,0,0};
				for (int j = 0; j <9; j++) {
					flag[map[i][j]-1] = 1;
				}

				int count = 0;
				for (int j = 0; j < 9; j++) {
					if(flag[j] == 1)
						count++;
				}
				if(count != 9) {
					sudoku = 0;
					break;
				}

				count = 0;
				flag = new int[]{0,0,0,0,0,0,0,0,0};
				for (int j = 0; j <9; j++) {
					flag[map[j][i]-1] = 1;
				}
				for (int j = 0; j < 9; j++) {
					if(flag[j] == 1)
						count++;
				}

				if(count != 9) {
					sudoku = 0;
					break;

				}
			}

			for(int i=0; i<9; i++) {
				int x = i/3*3;
				int y = i%3*3;
				
				int[] flag = new int[]{0,0,0,0,0,0,0,0,0};
				for (int j = 0; j < 3; j++) {
					for(int k =0; k<3; k++) {
						flag[map[x+j][y+k]-1] = 1;
					}
				}
				
				int count = 0;
				for (int j = 0; j < 9; j++) {
					if(flag[j] == 1)
						count++;
				}
				if(count != 9) {
					sudoku = 0;
					break;

				}
			}

			System.out.println("#" + test_case + " " + sudoku);

		}
	}
}

