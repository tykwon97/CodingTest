package noLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Pratice2_Solution {
	/*
	 * 15172. [연습문제] 헌터
	 * 제한 시간 초과 이후 제출 기한이 끝나서 테스트를 못해봄...아마도 통과겠지..?
	 */

	public static int[][] map;
	public static int[] dx = {1,0,-1,0};
	public static int[] dy = {0,1,0,-1};
	public static int[] loc;
	public static int N;
	public static int monster;
	public static int minCount;

	public static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testCase = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=testCase; tc++) {
			N = Integer.parseInt(in.readLine()); // 낚시터 자리의 개수

			loc = new int[8];
			
			monster = 0;
			map = new int[N+1][N+1];
			for (int i = 1; i < N+1; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 1; j < N+1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]<0){
						monster++;
						loc[map[i][j]*-1*2-1] = map[i][j];
					}else if(map[i][j]>0) {
						loc[map[i][j]*2-2] = map[i][j];
					}
				}
			}

			int[] result = new int[monster*2];
			
			minCount = Integer.MAX_VALUE;
			perm(0, 0, result);

			sb.append("#").append(tc).append(" ").append(minCount).append("\n");
		}
		System.out.println(sb);
	}

	private static void perm(int cnt, int flag, int[] result) {

		//순서 체크
		for (int i = 0; i < cnt; i++) {
			if(result[i]%2 == 0) { //몬스터일때
				boolean orderNotCorrect = false;
				for (int j = 0; j < i; j++) { // 앞에 고객이 있는 경우 오류
					if(result[j] == result[i]+1) {
						orderNotCorrect = true;
					}
				}
				if(orderNotCorrect)
					return;
			}
		}

		if(cnt == monster*2) {
//			System.out.println(Arrays.toString(result));
			hunter(result);
			return;
		}

		for (int i = 0; i < monster*2; i++) {
			if((flag & 1<<i) != 0) { 
				continue;
			}

			result[cnt] = i;
			perm(cnt+1, flag | 1<<i, result);
		}

	}

	private static void hunter(int[] result) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {1,1,0});
		
		boolean[][] isVisited = new boolean[N+1][N+1];

		int len = result.length;

		int seq = 0;
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int x = node[0];
			int y = node[1];
			int count = node[2];
			isVisited[x][y] = true;

			if(map[x][y] == loc[result[seq]]) {
				seq++;
				queue.clear();
				queue.offer(new int[] {x,y,count});
				isVisited = new boolean[N+1][N+1];
				if(seq >= len) {
					if(minCount > count) {
						minCount = count;
					}
					return;
				}
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int nextX = x+dx[i];
				int nextY = y+dy[i];
				
				if(nextX<1 || nextY<1 || nextX>=N+1 || nextY>=N+1)
					continue;
				if(isVisited[nextX][nextY])
					continue;
				queue.add(new int[] {nextX,nextY,count+1});
			}
		}
		
	}
}
