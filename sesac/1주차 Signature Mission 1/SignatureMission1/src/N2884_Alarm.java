import java.util.Scanner;

public class N2884_Alarm {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int H = input.nextInt();
		int M = input.nextInt();
		
		int min = H*60 + M;
		
		min = min-45;
		
		if(min<0) {
			min += 24*60;
		}
		
		int new_H = (int)min/60;
		int new_M = min %60;
		
		System.out.printf("%d %d",new_H,new_M);
	}

}