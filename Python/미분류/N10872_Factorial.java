import java.util.Scanner;

public class N10872_Factorial {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int maxValue = input.nextInt();
		int index = 1;
		
		for(int i=1;i<9;i++) {
			int value = input.nextInt();
			if(maxValue < value) {
				maxValue = value;
				index = i+1;
			}
		}
		
		System.out.println(maxValue);
		System.out.println(index);
	}

}
