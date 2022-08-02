package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2292_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(in.readLine());
		int count=1;
		if(1<=N & N<=1000000000)
		{
			if(N==1)
			{
				System.out.println(N);
			}
			else  //N이 1이 아닐때
			{
				N=N-2;//시작점이 2이므로
				while(N>=0)
				{
					N=N-(6*count);
					if(N<0)
						break;
					count++;
				}
				System.out.println(1+count);
			}
		}
	}
}