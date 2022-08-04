import java.util.Scanner;

public class N3009_FourthDot {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int[] arr_x = new int[3];
		int[] arr_y = new int[3];

		for(int i=0; i<3; i++) {
			int x = input.nextInt();
			int y = input.nextInt();

			arr_x[i] = x;
			arr_y[i] = y;

		}


		int result_x = 0 , result_y = 0;
		for(int i=0; i<3; i++) {
			int count_x = 0;
			int count_y = 0;

			for(int j=0; j<3; j++) {
				if(arr_x[i] == arr_x[j]) {
					count_x += 1;
				}
				if(arr_y[i] == arr_y[j]) {
					count_y += 1;
				}
			}

			if(count_x == 1) {
				result_x = arr_x[i];
			}
			if(count_y == 1) {
				result_y = arr_y[i];
			}
		}



		System.out.println(result_x +" "+ result_y);

	}

}
