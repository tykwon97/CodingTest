import java.util.Scanner;

public class N2577_NumberCount {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		int result = a*b*c;
		
		int[] arr = {0,0,0,0,0,0,0,0,0,0};
		while(result != 0){
			arr[result % 10] += 1;
			result = result/10;
		}
		for(int i=0;i<10;i++) {
			System.out.println(arr[i]);
		}
	}

}
