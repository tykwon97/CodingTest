import java.util.Arrays;
import java.util.Scanner;

public class N2309_SevenDwarfs {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] dwarfs = new int[9];
		int sum = 0;
		
		for(int i=0; i<9; i++) {
			dwarfs[i] = input.nextInt();
			sum += dwarfs[i];
		}
		
		for(int i=0; i<9; i++) {
			for(int j=i+1; j<9; j++) {
				if(sum-100 == dwarfs[i]+dwarfs[j]) {
					Arrays.sort(dwarfs);
					for(int k=0; k<9; k++) {	
						if(k == i || k == j) {
							continue;
						}
						System.out.println(dwarfs[k]);
					}
				}
			}
		}
	}
}
