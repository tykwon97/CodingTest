package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N6808_Solution {
	
	public static int win;
	public static int lose;
	public static int[] friend;
	public static int[] me;
	public static boolean[] isSelected; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// Friend랑 me 반대로 함
		// 결과도 win lose 순서 반대로 되어있음
		
		int num = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=num; tc++) {
			st = new StringTokenizer(in.readLine()," ");
			boolean[] flag = new boolean[19];
			isSelected = new boolean[9];
			
			friend = new int[9];
			for (int i = 0; i < 9; i++) {
				friend[i] = Integer.parseInt(st.nextToken());
				flag[friend[i]] = true;
			}
			
			me = new int[9];
			int index = 0;
			for (int i = 1; i <= 18; i++) {
				if(!flag[i])
					me[index++] = i;
			}
			
			win = 0;
			lose = 0;
			winCount(0,0,0);
			sb.append("#").append(tc).append(" ").append(lose).append(" ").append(win).append("\n");
		}
		System.out.println(sb);
	}

	private static void winCount(int myScore, int friendScore, int cnt) {
		
		if(cnt == 9) {
//			System.out.println(myScore+" "+friendScore);
			if(myScore > friendScore)
				win++;
			else if(myScore < friendScore)
				lose++;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(!isSelected[i]) { // 선택 안 된 경우
				isSelected[i] = true;
				if(me[i] > friend[cnt]) {
					winCount(myScore + (me[i]+friend[cnt]),friendScore,cnt+1);
				}else if(me[i] < friend[cnt]) {
					winCount(myScore,friendScore + (me[i]+friend[cnt]),cnt+1);
				}
				isSelected[i] = false;
			}
		}
	}
}
