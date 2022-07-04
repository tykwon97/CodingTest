import java.util.Scanner;

public class N5618_CommonFactor {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int[] arr = new int[n];
		int minValue = input.nextInt();
		arr[0] = minValue;
		for(int i=1;i<n;i++) {
			int x = input.nextInt();
			arr[i] = x;
			if(x<minValue) {
				minValue = x;
			}
		}
		
		for(int i=1; i<=minValue;i++ ) {
			boolean flag = true;
			for(int j=0; j<n; j++) {
				if(arr[j]%i != 0) {
					flag = false;
					break;
				}
			}
			if(flag)
				System.out.println(i);
		}

	}

}
