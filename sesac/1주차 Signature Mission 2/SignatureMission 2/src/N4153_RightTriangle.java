import java.util.Scanner;

public class N4153_RightTriangle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while(true) {
			int temp1 = input.nextInt();
			int temp2 = input.nextInt();
			int temp3 = input.nextInt();
			if(temp1==0 && temp1==temp2 && temp2==temp3) {
				break;
			}
			
			if(temp1 > temp3) {
				int temp = temp3;
				temp3 = temp1;
				temp1 = temp;
			}
			
			if(temp2 > temp3) {
				int temp = temp3;
				temp3 = temp2;
				temp2 = temp;
			}
			
			if(temp3*temp3 == temp1*temp1 + temp2*temp2) {
				System.out.println("right");
			}else {
				System.out.println("wrong");
			}
			
			
		}

	}

}
