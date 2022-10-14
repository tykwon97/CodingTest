package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class N17471_Main {

	public static int N;
	public static int[] areas;
	public static boolean[][] map;
	public static boolean[] isSelected;
	public static int minValue = Integer.MAX_VALUE;
	public static int[] elements;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		areas = new int[N];

		st = new StringTokenizer(in	.readLine()," ");
		for (int i = 0; i < N; i++) {
			areas[i] = Integer.parseInt(st.nextToken());
		}

		map = new boolean[N+1][N+1];
		for (int x = 1; x <= N; x++) {
			st = new StringTokenizer(in.readLine()," ");
			int M = Integer.parseInt(st.nextToken());
			for (int i = 0; i < M; i++) {
				int y = Integer.parseInt(st.nextToken());
				//				System.out.println("x : "+x +" y : "+y);
				map[x][y] = true;
				map[y][x] = true;
			}
		}

		isSelected = new boolean[N];
		subset(0);
		if(minValue == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(minValue);
	}

	private static void subset(int cnt) {
		if(cnt == N) {
			int minA = 0;
			int minB = 0;
	
			int count = 0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					count++;
				}
			}
			
			if(count == 0 || count == N)
				return;

			List<Integer> list1 = new LinkedList<>();
			List<Integer> list2 = new LinkedList<>();
//			System.out.print("1번 조합 : ");
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
//					System.out.print((i+1)+" ");
					list1.add(i+1);
					minA += areas[i];
				}
			}
//			System.out.println();
//			System.out.print("2번 조합 : ");
			for (int i = 0; i < N; i++) {
				if(!isSelected[i]) {
//					System.out.print((i+1)+" ");
					list2.add(i+1);
					minB+= areas[i];
				}
			}
//			System.out.println();

				
			elements = new int[N];
			for (int i = 0; i < N; i++) {
				elements[i] = i;
			}
			
			int index = 0;
			while(index != list1.size()) {
				int x = list1.get(index);
				for (int i = 0; i < list1.size(); i++) {
					if(index == i)
						continue;
					int y = list1.get(i);
//					System.out.println("A - x : "+x+" y : "+ y);
					if(map[x][y]) {
						union(x-1,y-1);
					}
				}
				index++;
			}
			
			index = 0;
			while(index != list2.size()) {
				int x = list2.get(index);
				for (int i = 0; i < list2.size(); i++) {
					if(index == i)
						continue;
					int y = list2.get(i);
//					System.out.println("A - x : "+x+" y : "+ y);
					if(map[x][y]) {
						union(x-1,y-1);
					}
				}
				index++;
			}
			
			
			
			
//			System.out.println(Arrays.toString(elements));
			HashSet<Integer> set = new HashSet<>();
			for (int i = 0; i < N; i++) {
				set.add(find(elements[i]));
			}

//			System.out.println("size : "+set.size());
			if(set.size() == 2) {
//				System.out.println("minA : "+minA+" minB : "+minB);
				minValue = Math.min(minValue, Math.abs(minA-minB));
			}

			return;
		}

		isSelected[cnt] = true;
		subset(cnt+1);	
		isSelected[cnt] = false;
		subset(cnt+1);
	}

	public static int find(int x) {
		if(elements[x] == x)
			return x;
		else
			return elements[x] = find(elements[x]);
	}


	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		elements[y] = x;

	}
}
