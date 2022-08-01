package com.ssafy.pre;

import java.util.Arrays;
import java.util.Scanner;

public class N2001_FlyAway {

	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int[][] result = new int[N-M+1][N-M+1];
			for(int i=0; i<N-M+1; i++) {
				for(int j=0; j<N-M+1; j++) {
					for(int k=0; k<M; k++) {
						for(int l=0; l<M; l++) {
							result[i][j] += map[i+k][j+l];
						}
					}
				}
			}
			
			int maxValue = -1;
			for(int[] list : result) {
				for(int x : list) {
					if(maxValue < x)
						maxValue = x;
				}
			}
			System.out.println("#" + test_case + " " + maxValue);
		
		}
	}
}