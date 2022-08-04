import java.util.Scanner;

public class N4619_Root {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int B,N;
		int total;
		int count;
		int minValue;

		while(true) {
			B = input.nextInt();
			N = input.nextInt();
			count = 1;
			minValue = 1000000;
			
			if(B == N && N == 0)
				break;
			
			total = count;
			for(int i=0; i<N-1; i++) {
				total *= count;
			}
			
			while(B>total) {
				if(Math.abs(B - total) < minValue) {
					minValue = B - total;
				}

//				System.out.println("count : "+count+" minValue : "+minValue+" total : "+total);
				count += 1;
				total = count;
				for(int i=0; i<N-1; i++) {
					total *= count;
				}
			}
			
			if(Math.abs(B - total) < minValue) {
				System.out.println(count);
			}else {
				System.out.println(count-1);
			}
		}
	}
}
