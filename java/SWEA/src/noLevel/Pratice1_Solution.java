package noLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pratice1_Solution {
	/*
	 * 15170. [연습문제] 낚시터 자리잡기
	 * 실수로 원래 방향과 양쪽이 모두 차지한 경우를 생각 못함 boolean flag 추가
	 */
	public static int[] loc;
	public static int[] people;
	public static boolean[] isSelected;
	public static int n;
	public static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testCase = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=testCase; tc++) {
			n = Integer.parseInt(in.readLine()); // 낚시터 자리의 개수
			loc = new int[n+1];
			people = new int[n+1];
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(in.readLine()," ");
				loc[i] = Integer.parseInt(st.nextToken());
				people[i] = Integer.parseInt(st.nextToken());
			}

			isSelected = new boolean[3];
			int[] result = new int[3];
			min  = Integer.MAX_VALUE;
			perm(result,0);
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}


	private static void perm(int[] result, int cnt) {
		if(cnt == 3) {
			boolean[] isVisited = new boolean[n+1];
			dfs(0,isVisited,0,result);
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			if(!isSelected[i]) {
				result[cnt] = i;
				isSelected[i] = true;
				perm(result, cnt+1);
				isSelected[i] = false;
			}
		}
	}


	private static void dfs(int cnt,boolean[] visited, int moveCount,int[] sequence) {
		boolean[] isVisited = new boolean[n+1];
		for (int i = 1; i < n+1; i++) {
			isVisited[i] = visited[i];
		}
		if(cnt==3) {
			if(moveCount<min)
				min = moveCount;
			return;
		}
		
		int row = loc[sequence[cnt]];
		int count = people[sequence[cnt]];

		int c = 0;
		while(count>0) {
			if(c==0) {
				if(!isVisited[row]) {
					isVisited[row] = true;
					count--;
					moveCount += c+1;
				}
			}else {
				if(count>=2) { //2개 이상 남았을 때 (어디 놓든 상관 없음)
					if(row-c>= 1 &&!isVisited[row-c]) { 
						isVisited[row-c] = true;
						count--;
						moveCount += c+1;
					}
					if(row+c <= n &&!isVisited[row+c]) { 
						isVisited[row+c] = true;
						count--;
						moveCount += c+1;
					}
					
				}else { // 1개 남았을 때
					boolean flag = false;
					if(row-c>= 1 && !isVisited[row-c]) { 
						moveCount += c+1;
						isVisited[row-c] = true;
						dfs(cnt+1,isVisited,moveCount,sequence);
						isVisited[row-c] = false;
						moveCount -= c+1;
						flag = true;

					}
					if(row+c <= n  && !isVisited[row+c]) { 
						moveCount += c+1;
						isVisited[row+c] = true;
						dfs(cnt+1,isVisited,moveCount,sequence);
						isVisited[row+c] = false;
						moveCount -= c+1;
						flag = true;
					}
					if(flag)
						return;
				}
			}
			c++;
		}

		//짝이 딱 맞는 경우
		dfs(cnt+1,isVisited,moveCount,sequence);
		return;
	}
}
