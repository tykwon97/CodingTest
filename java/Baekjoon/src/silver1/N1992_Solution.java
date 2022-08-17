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

public class N1992_Solution {
	public static char[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int num = Integer.parseInt(in.readLine());
		map = new char[num][num];
		for (int i = 0; i < num; i++) {
			map[i] = in.readLine().toCharArray();
		}
		quadTree(0,0,num); //시작좌표(x,y),크기
		System.out.println(sb);
	}

	private static void quadTree(int x, int y, int num) {
		
		boolean flag = true; //기저조건
		char c = map[x][y];
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if(c != map[x+i][y+j]) {
					flag = false;
					break;
				}
			}
		}
		if(flag) {
			sb.append(c);
			return;
		}else {
			sb.append('(');
			quadTree(x,y,num/2);
			quadTree(x,y+num/2,num/2);
			quadTree(x+num/2,y,num/2);
			quadTree(x+num/2,y+num/2,num/2);
		}
		sb.append(')');
	}
}
