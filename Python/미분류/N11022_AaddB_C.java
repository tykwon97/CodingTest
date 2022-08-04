import java.util.Scanner;

public class N11022_AaddB_C {

	public static void main(String[] args) {
		int n,A,B;
		
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		
		int[] arr = new int[n*2];
		
		for(int i=0; i<n; i++) {
			A = input.nextInt();
			B = input.nextInt();
			arr[i*2] = A;
			arr[i*2+1] = B;
		}
		
		for (int i=0; i<n; i++) {
			System.out.printf("Case #%d: %d + %d = %d\n", i+1, arr[i*2], arr[i*2+1], arr[i*2] + arr[i*2+1]);
		}
	}

}