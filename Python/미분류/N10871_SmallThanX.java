import java.util.Scanner;

public class N10871_SmallThanX {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int x = input.nextInt();
		
		String str = "";
		
		int k;
		
		for(int i=0; i<n; i++) {
			k = input.nextInt();
			if(k<x) {
				if(i != n-1) {
					str = str + k + " ";
				}else {
					str = str + k;
				}
			}
		}
		System.out.println(str);
	}

}