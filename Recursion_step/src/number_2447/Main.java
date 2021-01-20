package number_2447;

import java.util.Scanner;

//º° Âï±â - 10
public class Main {
	
	static Object star(int n,int size)
	{
		if(size == 1)
		{
			for(int i=0;i<n;i++)
				System.out.print("*");
			System.out.println();
		}
		
		if(true)
		{
			
		}
		return star(n,size);
	}

	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		
		star(num, 1);
	}

}
