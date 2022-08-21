package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class N2578_Solution {
	public static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				int x = Integer.parseInt(st.nextToken());
				boolean flag = bingo(x);
				if(flag) {
					System.out.println(i*5+j+1);
					return;
				}
			}
		}


	}

	private static boolean bingo(int x) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(arr[i][j] == x) {
					arr[i][j] = 0;
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < 5; i++) {
			boolean flag = true;
			for (int j = 0; j < 5; j++) {
				if(arr[i][j] != 0)
					flag = false;
			}
			if(flag)
				count++;
		}
		
		for (int i = 0; i < 5; i++) {
			boolean flag = true;
			for (int j = 0; j < 5; j++) {
				if(arr[j][i] != 0)
					flag = false;
			}
			if(flag)
				count++;
		}

		boolean flag1 = true;
		boolean flag2 = true;
		for (int i = 0; i < 5; i++) {
			if(arr[i][i] != 0)
				flag1 = false;
			if(arr[i][5-i-1] != 0)
				flag2 = false;
		}
		if(flag1)
			count++;
		if(flag2)
			count++;
		
		if(count>=3) {
			return true;
		}else
			return false;
	}
}
