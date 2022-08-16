package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class N2839_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		int num = Integer.parseInt(in.readLine());
		
		int cnt = 0;
		
		int q = num/5;
		
		while(q != -1) {
			if(num%5 == 0) {
				cnt = q;
				break;
			}else {
				cnt = q;
				if( (num-5*q)%3 == 0) {
					cnt += (num-5*q)/3;
					break;
				}
			}
			q = q-1;
			if(q == -1)
				cnt = -1;
		}
		System.out.println(cnt);
		
	}
}
