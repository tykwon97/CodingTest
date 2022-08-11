package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class N2023_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		
		int num = (int) Math.pow(10, n);
		boolean[] arr = new boolean[num];
		arr[0] = true;
		arr[1] = true;
		for (int i = 2; i < arr.length; i++) {
			if(arr[i] == false) {
				for (int j = i+i; j < arr.length; j += i) {
					arr[j] = true;
				}
			}
		}
		
//		System.out.println(Arrays.toString(arr));
		for(int i=(int)Math.pow(10, n-1);i<num;i++) {
			String x = i+"";
			String y = "";
			int z=0;
			boolean flag = true;
			for (int j = 0; j < n; j++) {
				y += x.charAt(j);
				z = Integer.parseInt(y);
				if(arr[z]) {
					flag = false;
					break;
				}
			}
			if(flag) {
//				System.out.println("z : "+z +" arr[z-1]"+arr[z-1]);
				sb.append(y).append("\n");
			}
			
		}
		
		
		System.out.println(sb);
	}
}


