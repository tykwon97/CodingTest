import java.util.Scanner;

public class N1085_EscapeFromRectangle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int x = input.nextInt();
		int y = input.nextInt();
		int w = input.nextInt();
		int h = input.nextInt();

		int xy, min_xy;
		if(x>y) {
			xy = y;
		}else {
			xy = x;
		}
		
		int min_x = w-x;
		int min_y = h-y;
		
		if(min_x > min_y) {
			min_xy = min_y;
		}else {
			min_xy = min_x;
		}
		
		if(xy > min_xy) {
			System.out.println(min_xy);
		}else {
			System.out.println(xy);
		}
	
		

	}

}
