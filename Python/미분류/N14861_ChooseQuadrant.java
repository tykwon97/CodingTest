import java.util.Scanner;

public class N14861_ChooseQuadrant {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int x,y;
		x = input.nextInt();
		y = input.nextInt();
		
		if(x>0) {
			if(y>0) {
				System.out.println("1");
			}else {
				System.out.println("4");
			}
		}else {
			if(y>0) {
				System.out.println("2");
			}else {
				System.out.println("3");
			}
		}
		
	}

}
