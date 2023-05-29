package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14620_Main {
	public static int minCost;
	public static boolean[][] isVisted;
	public static int[][] costs;
	public static int N;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        
        costs = new int[N][N];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				costs[i][j] =Integer.parseInt(st.nextToken());
			}
		}
        isVisted = new boolean[N][N];
        minCost = Integer.MAX_VALUE;
        
        comb(0);
        System.out.println(minCost);
    }

	private static void comb(int cnt) {
		System.out.println("hi");
		if(cnt == 3) {
			System.out.println("shit");
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(isVisted[i][j])
						count += costs[i][j];
				}
			}
			if(count < minCost)
				minCost = count;
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(isVisted[i][j])
					continue;
				isVisted[i][j] = true;
				//사방탐색
				for (int k = 0; k < 4; k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					if(nx<0 || nx>=N || ny<0 || ny>=N)
						return;
					isVisted[nx][ny] = true;
				}
				comb(cnt+1);
				isVisted[i][j] = false;
				
			}
		}
		
	}
}