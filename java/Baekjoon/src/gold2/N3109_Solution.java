package gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N3109_Solution {
	
	static char[][] arr;
	static boolean[] isSelected;
	static int r;
	static int c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine()," ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		isSelected = new boolean[r];
		
		arr = new char[r][c];
		for (int i = 0; i < r; i++) {
			arr[i] = in.readLine().toCharArray();
		}
		
		int count = 0;
		for (int i = 0; i < r; i++) {
			int x = pipe(i,1);
			if(x==1)
				count++;
//			System.out.println(x);
		}
		
//		for(char[] map : arr) {
//			for(char x : map) {
//				System.out.print(x+" ");
//				
//			}
//			System.out.println();
//		}
		System.out.println(count);
		
	}

	private static int pipe(int rowNo, int colNo) {
		
		if(colNo == c-1) {
			isSelected[rowNo] = true;
			return 1;
		}
		int x = -1;
		for (int i = -1; i <= 1; i++) {
			if(rowNo+i >= 0 && rowNo+i < r) {
				if(arr[rowNo+i][colNo] == 'x' || arr[rowNo+i][colNo] == 'o')
					continue;
				
				arr[rowNo+i][colNo] = 'o';
				x = pipe(rowNo+i,colNo+1);
			}
			if(x==1) return x;
		}
		return -1;
	}
}
