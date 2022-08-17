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

				map[x][y] = -1; // BC위치

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
									map[j][k] = -2; // Math.max(map[j][k], p); //겹치는 경우
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

			int totalA = 0;
			int totalB = 0;
			int total = 0;

			//				for(String[] strs : flag) {
			//					for(String x : strs) {
			//						System.out.print("["+x+"] ");
			//					}
			//					System.out.println();
			//				}


			if(map[aX][aY] != -2) {
				totalA += map[aX][aY];
			}else {
				int n = Integer.parseInt(flag[aX][aY]);
				totalA += coverage[n];
			}

			if(map[bX][bY] != -2) {
				totalB += map[bX][bY];
			}else {
				int n = Integer.parseInt(flag[bX][bY]);
				totalB += coverage[n];
			}

			for (int i = 0; i < m; i++) {
				aX += dx[aMove[i]];
				aY += dy[aMove[i]];
				bX += dx[bMove[i]];
				bY += dy[bMove[i]];
				//System.out.println(aX+" "+aY+" "+bX+" "+bY);

				//					int yyy = 0;
				//					for (int[] arr : map) {
				//						int xxx = 0;
				//						for(int x : arr) {
				//							if(aX == yyy && aY == xxx) {
				//	
				//								System.out.printf("%3d ",99);
				//							}else if(bX == yyy && bY == xxx) {
				//								System.out.printf("%3d ",77);
				//							}else{
				//								System.out.printf("%3d ",x);
				//							}
				//							xxx++;
				//						}
				//						yyy++;
				//						System.out.println();
				//					}
				//					System.out.println(flag[aX][aY]+" || "+flag[bX][bY]);
				if(!flag[aX][aY].equals("") && flag[aX][aY].equals(flag[bX][bY]) && flag[aX][aY].length() == 1) {
					if(map[aX][aY] != -2) {
						totalA += map[aX][aY]/2;
					}else {
						int n = Integer.parseInt(flag[aX][aY]);
						totalA += coverage[n]/2;
					}

					if(map[bX][bY] != -2) {
						totalB += map[bX][bY]/2;
					}else {
						int n = Integer.parseInt(flag[bX][bY]);
						totalB += coverage[n]/2;
					}

				}else if(flag[aX][aY] != flag[bX][bY]){
					if(flag[aX][aY].equals("") || flag[bX][bY].equals("")) {			
						if(!flag[aX][aY].equals("")) {
							if(flag[aX][aY].length() == 1) {
								if(map[aX][aY] != -2) {
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
								//								System.out.println("maxc");
								totalA += max; 
							}
						}
						if(!flag[bX][bY].equals("")) {
							if(flag[bX][bY].length() == 1) {
								if(map[bX][bY] != -2) {
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
								//								System.out.println("maxc");
								totalB += max; 
							}
						}

						//													System.out.println("A : "+totalA+" B : "+totalB+"\n");
						continue;
					}
					if(flag[aX][aY].length() != 1 || flag[bX][bY].length() != 1) {

						if(flag[aX][aY].length() == 1 && flag[bX][bY].length() != 1) {
							if(map[aX][aY] != -2) {
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
									//									System.out.println(max);
								}
							}
							//							System.out.println("maxb");
							totalB += max; 
						}else if(flag[aX][aY].length() != 1 && flag[bX][bY].length() == 1) {
							if(map[bX][bY] != -2) {
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
									//									System.out.println(max);
								}
							}
							//							System.out.println("maxa");
							totalA += max; 
						}else if(flag[aX][aY].length() != 1 && flag[bX][bY].length() != 1) {
							String[] aa = flag[aX][aY].split(" ");
//							System.out.println("shit"+flag[aX][aY]);
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

							//								System.out.println("aIndex1 : "+aIndex1+" aIndex2 : "+aIndex2);

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

							//								System.out.println("bIndex1 : "+bIndex1+" bIndex2 : "+bIndex2);

							if(aIndex1 == bIndex1) {
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
							//							System.out.println("woo");
						}


					}else {
						//							System.out.println();
						if(map[aX][aY] != -2) {
							totalA += map[aX][aY];
						}else {
							int n = Integer.parseInt(flag[aX][aY]);
							totalA += coverage[n];
						}

						if(map[bX][bY] != -2) {
							totalB += map[bX][bY];
						}else {
							int n = Integer.parseInt(flag[bX][bY]);
							totalB += coverage[n];
						}
						//							System.out.println("what");
					}
				}

			}
			total = totalA + totalB;



			sb.append("#").append(tc).append(" ").append(total).append("\n");
		}
		System.out.println(sb);
	}
}
