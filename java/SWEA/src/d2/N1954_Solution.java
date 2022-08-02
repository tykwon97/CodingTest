package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class N1954_Solution {

	public static int[][] arr;
	public static int num;
	
	public static void snail(int x, int y, int n,boolean flag) {
		if(x>=0 && x<num && y>= 0 && y<num) {
			if(arr[x][y] != 0)
				return;
			arr[x][y] = n;
		}else {
			return;
		}

		if(flag) {
			snail(x,y+1,n+1,true);
			snail(x+1,y,n+1,true);
			snail(x,y-1,n+1,true);
			snail(x-1,y,n+1,false);
		}else {
			snail(x-1,y,n+1,false);
			snail(x,y+1,n+1,true);
			snail(x+1,y,n+1,true);
			snail(x,y-1,n+1,true);
		}
	}

	public static void main(String args[]) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			num = Integer.parseInt(in.readLine());
			arr = new int[num][num];
			snail(0,0,1,true);
			
			System.out.println("#" + test_case);
			
			for(int[]a : arr) {
				for(int x : a) {
					System.out.print(x+" ");
				}
				System.out.println();
			}
        }
	}
}