package number_10870;

import java.util.Scanner;

/*
 * 피보나치 수 5
 */
public class Main {

	static int Fibonacci(int n,int a1,int a2)
	{
		if(n==1)
		{
			return a2;
		}
		else
			return Fibonacci(--n,a2,a1+a2);
	}
	
	public static void main(String[] args) {
		
		int num;
		int num1 = 0;
		int num2 = 1;
		
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		if(num==0)
			System.out.println("0");
		else
			System.out.println(Fibonacci(num,num1,num2));
	}

}
