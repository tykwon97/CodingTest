package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1080_Main {
	public static char[][] A;
	public static char[][] B;
	public static int minValue;

	public static int N;
	public static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		if(N<3 || M<3) {
			System.out.println("-1");
			return;
		}

		A = new char[N][M];
		B = new char[N][M];

		for (int i = 0; i < N; i++) {
			A[i] = in.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			B[i] = in.readLine().toCharArray();
		}

		minValue = Integer.MAX_VALUE;

		matrix(0,0,-1,-1,0);

		if(minValue == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(minValue);	
	}

	private static void matrix(int x, int y, int prevx, int prevy, int min) {
		if(min != 0) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					int nx = x+i;
					int ny = y+j;
					if(nx == prevx && ny == prevy) {
						continue;
					}
					if(A[nx][ny] == '1') {
						A[nx][ny] = '0';
					}else {
						A[nx][ny] = '1';	
					}
				}
			}
		}

		if(min>= 9) {
			return;
		}
		int count = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		for (int j = 0; j < N-2; j++) {
			for (int k = 0; k < M-2; k++) {

				int value = 0;
				for (int i = 0; i < 3; i++) {
					for (int l = 0; l < 3; l++) {
						if(A[j+i][k+l] != B[j+i][k+l])
							value++;
					}	
				}

				if(value > count) {
					queue.clear();
					count = value;
					queue.add(new int[] {j,k});
				}else if(value == count){
					queue.add(new int[] {j,k});
				}
			}
		}
		if(count == 0) {
			System.out.println("x : "+x+" y : "+y+"prevx  : "+prevx+" prevy : "+prevy);
			if(minValue > min)
				minValue = min;
			return;
		}
		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			int nx = xy[0];
			int ny = xy[1];
			if(min == 0)
				matrix(nx,ny,x,y,min+1);
			else
				matrix(nx,ny,nx,ny,min+1);
		}

	}
}
