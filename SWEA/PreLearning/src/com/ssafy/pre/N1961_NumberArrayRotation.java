package com.ssafy.pre;

import java.util.Arrays;
import java.util.Scanner;

public class N1961_NumberArrayRotation {

	public static void main(String args[]) throws Exception
	{
		Scanner input = new Scanner(System.in);
		int T;
		T=input.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = input.nextInt();
            
            // 배열 초기화 및 선언
            int[][] map = new int[N][N];
            for(int i=0; i<N; i++) {
            	for(int j=0; j<N; j++) {
            		map[i][j] = input.nextInt();
            	}
            }
            
            int[][] map90 = new int[N][N];
            for(int i=0; i<N; i++) {
            	for(int j=0; j<N; j++) {
            		map90[j][N-1-i] = map[i][j];
            	}
            }
            
            int[][] map180 = new int[N][N];
            for(int i=0; i<N; i++) {
            	for(int j=0; j<N; j++) {
            		map180[j][N-1-i] = map90[i][j];
            	}
            }
            
            int[][] map270 = new int[N][N];
            for(int i=0; i<N; i++) {
            	for(int j=0; j<N; j++) {
            		map270[j][N-1-i] = map180[i][j];
            	}
            }
            
			
			System.out.println("#" + test_case);
			 for(int i=0; i<N; i++) {
	            	for(int j=0; j<N; j++) {
	            		System.out.print(map90[i][j]);
	            	}
	            	System.out.print(" ");
	            	
	            	for(int j=0; j<N; j++) {
	            		System.out.print(map180[i][j]);
	            	}
	            	System.out.print(" ");
	            	
	            	for(int j=0; j<N; j++) {
	            		System.out.print(map270[i][j]);
	            	}
	            	System.out.println();
	            }
        }
	}
}

//123
//456
//789
//
//741
//852
//963
//
//987
//654
//321
