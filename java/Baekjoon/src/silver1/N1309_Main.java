package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1309_Main {
	public static int N;
	public static int cnt;
	public static int[][] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		selected = new int[2*N][2];

		
		selected[0][0] = 1; // 0일때 사자 없는 경우
		selected[0][1] = 1; // 1일때 사자 있는 경우
		
		System.out.println(cnt%9901);
	}
}
