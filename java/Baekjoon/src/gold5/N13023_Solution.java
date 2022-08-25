package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N13023_Solution {

	public static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());


		p = new int[n];

		for (int i = 0; i < n; i++) {
			makeSet(i);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			unionSet(a,b);
		}
		System.out.println(Arrays.toString(p));
		boolean flag = true;
		int index = p[0];
		for (int i = 1; i < p.length; i++) {
			if(index != p[i]) {
				flag = false;
				break;
			}
		}
		if(flag) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
	}
	
	public static void makeSet(int i) {
		p[i] = i ;
	}

	public static int findSet(int x){
		if(p[x] == x)
			return x;
		else
			return p[x] = findSet(p[x]);
	}

	public static void unionSet(int x, int y){
		if(findSet(x) == findSet(y))
			return;
		p[findSet(y)] = findSet(x);
	}
}
