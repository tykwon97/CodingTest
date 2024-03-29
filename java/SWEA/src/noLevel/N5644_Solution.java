package noLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N5644_Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testCase = Integer.parseInt(in.readLine());

		for(int tc=1; tc<=testCase; tc++) {
			st = new StringTokenizer(in.readLine(), " ");

			int[][] map = new int[10][10];
			String[][] flag = new String[10][10]; //단순히 어떤 BC에 속해있는지 알려줌
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					flag[i][j] = "";
				}
			}
			int m = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken()); 

			int aMove[] = new int[m];
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < m; i++) {
				aMove[i] = Integer.parseInt(st.nextToken());
			}

			int bMove[] = new int[m];
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < m; i++) {
				bMove[i] = Integer.parseInt(st.nextToken());
			}

			int[] coverage = new int[a];

			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int y = Integer.parseInt(st.nextToken())-1; //x,y 반대로 들어옴
				int x = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken()); // Coverage 
				int p = Integer.parseInt(st.nextToken()); // Performance

				coverage[i] = p;

				for (int j = x-c; j <= x+c; j++) {
					for (int k = y-c; k <= y+c; k++) {
						if(j>= 0 && j<10 && k>=0 && k<10) {// && (j!=x || k!=y)) {
							if(Math.abs(x-j) + Math.abs(y-k) <= c) {
								if(map[j][k] == 0)
									map[j][k] = p;
								else { //겹치는 경우
									map[j][k] = -2; 
								}

								if(flag[j][k].equals(""))
									flag[j][k] = i+"";
								else { //겹치는 경우
									flag[j][k] += (" "+i); 
								}
							}
						}
					}
				}
			}

			int aX = 0, aY = 0;
			int bX = 9, bY = 9;

			// 이동하지 않음,상 (UP),우 (RIGHT),하 (DOWN),좌 (LEFT)
			int[] dx = {0,-1,0,1,0};
			int[] dy = {0,0,1,0,-1};

			int totalA = 0, totalB = 0, total = 0;

			if(map[aX][aY] != -2) {
				totalA += map[aX][aY];
			}else {
				String[] str = flag[aX][aY].split(" ");
				int max = Integer.MIN_VALUE;
				for(String x : str) {
					int n = Integer.parseInt(x);
					if(max<coverage[n])
						max = coverage[n];
				}
				totalA += max; 
			}

			if(map[bX][bY] != -2) {
				totalB += map[bX][bY];
			}else {
				String[] str = flag[bX][bY].split(" ");
				int max = Integer.MIN_VALUE;
				for(String x : str) {
					int n = Integer.parseInt(x);
					if(max<coverage[n])
						max = coverage[n];
				}
				totalB += max; 
			}

			for (int i = 0; i < m; i++) {
				aX += dx[aMove[i]];
				aY += dy[aMove[i]];
				bX += dx[bMove[i]];
				bY += dy[bMove[i]];

				if(!flag[aX][aY].equals("") && flag[aX][aY].length() == 1 && flag[aX][aY].equals(flag[bX][bY])) {
					if(map[aX][aY] != -1) {
						totalA += map[aX][aY]/2;
					}else {
						int n = Integer.parseInt(flag[aX][aY]);
						totalA += coverage[n]/2;
					}

					if(map[bX][bY] != -1) {
						totalB += map[bX][bY]/2;
					}else {
						int n = Integer.parseInt(flag[bX][bY]);
						totalB += coverage[n]/2;
					}

				}else if(flag[aX][aY] != flag[bX][bY]){
					if(flag[aX][aY].equals("") || flag[bX][bY].equals("")) {			
						if(!flag[aX][aY].equals("")) {
							if(flag[aX][aY].length() == 1) {
								if(map[aX][aY] != -1) {
									totalA += map[aX][aY];
								}else {
									int n = Integer.parseInt(flag[aX][aY]);
									totalA += coverage[n];
								} 
							}else {
								String[] str = flag[aX][aY].split(" ");
								int max = Integer.MIN_VALUE;
								for(String x : str) {
									int n = Integer.parseInt(x);
									if(max<coverage[n])
										max = coverage[n];
								}
								totalA += max; 
							}
						}
						if(!flag[bX][bY].equals("")) {
							if(flag[bX][bY].length() == 1) {
								if(map[bX][bY] != -1) {
									totalB += map[bX][bY];
								}else {
									int n = Integer.parseInt(flag[bX][bY]);
									totalB += coverage[n];
								}
							}else {
								String[] str = flag[bX][bY].split(" ");
								int max = Integer.MIN_VALUE;
								for(String x : str) {
									int n = Integer.parseInt(x);
									if(max<coverage[n])
										max = coverage[n];
								}
								totalB += max; 
							}
						}
						continue;
					}
					if(flag[aX][aY].length() != 1 || flag[bX][bY].length() != 1) {
						if(flag[aX][aY].length() == 1 && flag[bX][bY].length() != 1) {
							if(map[aX][aY] != -1) {
								totalA += map[aX][aY];
							}else {
								int n = Integer.parseInt(flag[aX][aY]);
								totalA += coverage[n];
							}
							String[] str = flag[bX][bY].split(" ");
							int max = Integer.MIN_VALUE;
							for(String x : str) {
								int n = Integer.parseInt(x);
								if(n != Integer.parseInt(flag[aX][aY])) {
									if(max<coverage[n])
										max = coverage[n];
								}
							}
							totalB += max; 
						}else if(flag[aX][aY].length() != 1 && flag[bX][bY].length() == 1) {
							if(map[bX][bY] != -1) {
								totalB += map[bX][bY];
							}else {
								int n = Integer.parseInt(flag[bX][bY]);
								totalB += coverage[n];
							}
							String[] str = flag[aX][aY].split(" ");
							int max = Integer.MIN_VALUE;
							for(String x : str) {
								int n = Integer.parseInt(x);
								if(n != Integer.parseInt(flag[bX][bY])) {
									if(max<coverage[n])
										max = coverage[n];
								}
							}
							totalA += max; 
							
						}else{
							String[] aa = flag[aX][aY].split(" ");
							int maxA1 = Integer.MIN_VALUE;
							int maxA2 = Integer.MIN_VALUE;
							int aIndex1 = Integer.parseInt(aa[0]);
							int aIndex2 = Integer.parseInt(aa[0]);
							for(int j=0; j<aa.length; j++) {
								int n = Integer.parseInt(aa[j]);
								if(maxA1<coverage[n]) {
									maxA2 = maxA1;
									aIndex2 = aIndex1;
									maxA1 = coverage[n];
									aIndex1 = n;
								}else if(maxA2 < coverage[n]) {
									maxA2 = coverage[n];
									aIndex2 = n;
								}
							}

							String[] bb = flag[bX][bY].split(" ");
							int maxB1 = Integer.MIN_VALUE;
							int maxB2 = Integer.MIN_VALUE;
							int bIndex1 = Integer.parseInt(bb[0]);
							int bIndex2 = Integer.parseInt(bb[0]);
							for(int j=0; j<bb.length; j++) {
								int n = Integer.parseInt(bb[j]);
								if(maxB1<coverage[n]) {
									maxB2 = maxB1;
									bIndex2 = bIndex1;
									maxB1 = coverage[n];
									bIndex1 = n;
								}else if(maxB2 < coverage[n]) {
									maxB2 = coverage[n];
									bIndex2 = n;
								}
							}

							if(coverage[aIndex1] == coverage[bIndex1]) {
								if(coverage[aIndex2] > coverage[bIndex2]) {
									totalA += coverage[aIndex2]; 
									totalB += coverage[bIndex1];	
								}else {
									totalA += coverage[aIndex1]; 
									totalB += coverage[bIndex2];
								}
							}else {
								totalA += coverage[aIndex1]; 
								totalB += coverage[bIndex1];	
							}
						}

					}else {
						if(map[aX][aY] != -2 && map[aX][aY] != -1) {
							totalA += map[aX][aY];
						}else {
							String[] str = flag[aX][aY].split(" ");
							int max = Integer.MIN_VALUE;
							for(String x : str) {
								int n = Integer.parseInt(x);
								if(max<coverage[n])
									max = coverage[n];
							}
							totalA += max; 
						}

						if(map[bX][bY] != -2 && map[bX][bY] != -1) {
							totalB += map[bX][bY];
						}else {
							String[] str = flag[bX][bY].split(" ");
							int max = Integer.MIN_VALUE;
							for(String x : str) {
								int n = Integer.parseInt(x);
								if(max<coverage[n])
									max = coverage[n];
							}
							totalB += max; 
						}
					}
				}else {
					if(aX == bX && aY == bY && flag[aX][aY].length() > 1) {
						String[] aa = flag[aX][aY].split(" ");
						int maxA1 = Integer.MIN_VALUE;
						int maxA2 = Integer.MIN_VALUE;
						int aIndex1 = Integer.parseInt(aa[0]);
						int aIndex2 = Integer.parseInt(aa[0]);
						for(int j=0; j<aa.length; j++) {
							int n = Integer.parseInt(aa[j]);
							if(maxA1<coverage[n]) {
								maxA2 = maxA1;
								aIndex2 = aIndex1;
								maxA1 = coverage[n];
								aIndex1 = n;
							}else if(maxA2 < coverage[n]) {
								maxA2 = coverage[n];
								aIndex2 = n;
							}
						}
						totalA += coverage[aIndex1]; 
						totalB += coverage[aIndex2];
						continue;
					}
				}
			}
			total = totalA + totalB;

			sb.append("#").append(tc).append(" ").append(total).append("\n");
		}
		System.out.println(sb);
	}
}