package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1074_Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		
		int count = 0;
		while(n != 0) {
			
			int x = (int) (Math.pow(2, n))/2;
			System.out.println("r : "+r+" c: "+c+" x : "+x);
			if(x-1 <= r) {
				if(x-1 <= c) {
					count += x*x;
					c -= x;
				}
				count += x*(int) (Math.pow(2, n));
				r -= x;
				
			}else {
				if(x-1 <= c) {
					count += x*x;
					c -= x;
				}
				
			}
			
			n -= 1;
		}
		System.out.println(count);
		
	}
}
