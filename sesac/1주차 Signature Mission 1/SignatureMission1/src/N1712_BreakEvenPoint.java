import java.util.Scanner;

public class N1712_BreakEvenPoint {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		long A = input.nextInt();
		long B = input.nextInt();
		float C = input.nextInt();
		
		if(C>B) {
			System.out.println((int)(A/(C-B))+1);
		}else {
			System.out.println("-1");
		}
		
	}

}
