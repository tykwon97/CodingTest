package number_10872;

import java.util.Scanner;

public class Main {

	public static int factorial(int n)
	//static 사용해야되는 이유?
	{
		if(n==1 || n==0)
		{
			return 1;
		}
		else
		{
			return n*factorial(--n);
		}
	}
	
	public static void main(String[] args) {
		int num;
		int result=0;
		
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		
		result=factorial(num);
		System.out.println(result);
		
		

	}

}
