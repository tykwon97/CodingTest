package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2961_Solution {

	public static int[] arr;
	public static int min;
	public static int num;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		num = Integer.parseInt(in.readLine());
		
		arr = new int[num*2];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int sweet = Integer.parseInt(st.nextToken());
			arr[i*2] = sweet;
			int bitter = Integer.parseInt(st.nextToken());
			arr[i*2+1] = bitter;
		}
		
		comb(1,0,0);
		System.out.println(min);
	}

	private static void comb(int sweet, int bitter, int index) {
		if(index>=num*2) {
			if(sweet == 1 && bitter == 0)
				return;
			int value = Math.abs(sweet-bitter);
			if(min>value)
				min = value;
			return;
		}
		comb(sweet,bitter,index+2);
		comb(sweet*arr[index],bitter+arr[index+1],index+2);
	}
}
