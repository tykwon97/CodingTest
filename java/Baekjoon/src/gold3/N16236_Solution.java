package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class N16236_Solution {
	
	static String[][] map;
	static int N;
	static int sharkCount;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static boolean[][] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		map = new String[N][N];	
		isSelected = new boolean[N][N];
		
		int sharkX = 0;
		int sharkY = 0;
		sharkCount = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken();
				if(map[i][j].equals("9")) {
					sharkX = i;
					sharkY = j;
				}else if(!map[i][j].equals("0") && !map[i][j].equals("9")) {
					sharkCount++;
				}
			}
		}
		map[sharkX][sharkY] = "0";
		eatFish(sharkX, sharkY);
		
	}

	private static void eatFish(int sharkX, int sharkY) {
			Queue<int[]> queue = new ArrayDeque<int[]>();
			int[] startLocation = new int[5];
			startLocation[0] = sharkX;
			startLocation[1] = sharkY;
			startLocation[2] = 2;
			startLocation[3] = 0;
			startLocation[4] = 0;
			queue.add(startLocation);
			isSelected[sharkX][sharkY] = true;
			
			while(!queue.isEmpty()) {
				int[] sharkLocation = queue.poll();
				int x = sharkLocation[0];
				int y = sharkLocation[1];
				int size = sharkLocation[2];
				int eatFish = sharkLocation[3];
				int time = sharkLocation[4];

//				System.out.println("x : "+x+" y : "+y);

				for (int i = 0; i < 4; i++) {
					int nextX = x+dx[i];
					int nextY = y+dy[i];
					
					if(sharkCount == 0) {
						System.out.println(time);
						return;
					}
//					System.out.println("nextX : "+nextX+" nextY : "+nextY);
					if(nextX<0 || nextX>=N || nextY <0 || nextY>=N)
						break;

					if(!isSelected[nextX][nextY]) {

						isSelected[nextX][nextY] = true;
						if(Integer.parseInt(map[nextX][nextY]) < size) {
							if(!map[nextX][nextY].equals("0") && !map[nextX][nextY].equals("9")) {
//								System.out.println(map[nextX][nextY] +" : "+ size);
								map[nextX][nextY] = "0";
								
								System.out.println("nextX : "+nextX+" nextY : "+nextY+" size : "+size+" eatFish : "+eatFish+" time : "+time);
//								queue.clear();
								if(eatFish+1 == size) {
									queue.add(new int[] {nextX, nextY, size+1,0,time+1});
								}else {
									System.out.println("what?");
									queue.add(new int[] {nextX, nextY, size, eatFish+1 ,time+1});
								}
								sharkCount --;
								continue;
							}else if(map[nextX][nextY].equals("9")){
								continue;
							}else {
								queue.add(new int[] {nextX, nextY, size,eatFish,time+1});
							}
							
						}else {
							continue;
						}
					}
					
					if(sharkCount == 0) {
						System.out.println(time+1);
						return;
					}
					
				}
				
				
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j <N; j++) {
//						System.out.print(map[i][j] + " ");
//					}
//					System.out.println();
//				}
			}
	}

}
