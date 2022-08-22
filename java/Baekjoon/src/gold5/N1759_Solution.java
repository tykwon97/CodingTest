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

public class N1759_Solution {
	public static int chickenHouse;
	public static int[][] map ;
	public static int[] x ;
	public static int[] y ;
	public static int n ;
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		Queue<Integer> queue = new LinkedList<>();
		chickenHouse = 0; // 치킨 집 개수
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					chickenHouse++;
					queue.add(i);
					queue.add(j);
				}
			}	
		}
		x = new int[chickenHouse]; // 치킨 집 x좌표
		y = new int[chickenHouse]; // 치킨 집 y좌표
		for (int i = 0; i < chickenHouse; i++) {
			x[i] = queue.poll();
			y[i] = queue.poll();
		}
		
		comb(m,0,0);
		sb.append(min);
		System.out.println(min);
	}

	private static void comb(int chicken, int index,int flag) {
		
		if(chicken == 0) {
			List<Integer> list = new LinkedList<>();
			for (int i = 0; i < chickenHouse; i++) {
				if( (flag & 1<<i ) != 0) {
					list.add(i);
				}
			}	
			
//			for(int x : list) {
//				System.out.print(x+" ");
//			}
//			System.out.println();
			int total = 0; //전체
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if(map[j][k] == 1) { // 1만나면 다 체크
						int value = Integer.MAX_VALUE; //한 번
						for (int i = 0; i < list.size(); i++) { // 치킨집 거리 다 구하기
							int temp = Math.abs(j-x[list.get(i)])+ Math.abs(k-y[list.get(i)]);
							if(value > temp) {
								value = temp;
							}
						}
						total += value;
					}
				}
			}
			if(min>total) {
				min = total;
			}
			return;
		}

		for (int i = index; i < chickenHouse; i++) {
			if( (flag & 1<<i ) != 0) continue; //선택된 경우
			comb(chicken-1, i+1, flag | 1<<i);
		}

	}
}
