import java.util.Scanner;

public class N2908_Constant {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int str1 = input.nextInt();
		int str2 = input.nextInt();
		
		str1 = (str1%10*100) + (str1/10%10*10) + str1/100;
		str2 = (str2%10*100) + (str2/10%10*10) + str2/100;
		
		if(str1>str2) {
			System.out.print(str1);
		}else {
			System.out.print(str2);
		}

	}

}
