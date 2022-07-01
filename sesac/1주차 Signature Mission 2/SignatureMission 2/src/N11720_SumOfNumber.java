import java.util.Scanner;

public class N11720_SumOfNumber {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		String num = input.next();
		
		int result = 0;
		for(int i=0; i<num.length(); i++) {
			char x = num.charAt(i);
			result += (int)x -'0';
		}
		System.out.println(result);
	}

}
