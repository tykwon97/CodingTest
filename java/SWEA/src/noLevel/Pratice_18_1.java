package noLevel;

import java.util.Arrays;
import java.util.Scanner;

public class Pratice_18_1 {
	
	static int[] apt;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		apt = new int[N+1];
		Arrays.fill(apt, -1);
		apt[0] = 0;
		apt[1] = 2;
		apt[2] = 3;
		fibo(N);
		
		System.out.println(apt[N]);
	}
	
	static int fibo(int n) {
		if(apt[n] == -1)
			apt[n] =  fibo(n-1)+fibo(n-2);
		return apt[n];
	}
}
