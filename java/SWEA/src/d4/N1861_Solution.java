package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1861_Solution {
	
	public static int n;
	public static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=num; tc++) {
			n = Integer.parseInt(in.readLine());
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine()," ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxResult = 0;
			int maxRoom = Integer.MAX_VALUE;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int result = findRoom(i,j,arr[i][j],0);
					if(result > maxResult) {
						maxResult = result;
						maxRoom = arr[i][j];
					}else if(result == maxResult) { 
						if(maxRoom > arr[i][j]) // 최대인 방이 여럿이라면 그 중에서 적힌 수가 가장 작은 것을 출력
							maxRoom = arr[i][j];
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(maxRoom).append(" ").append(maxResult).append("\n");
		}
		System.out.println(sb);
	}

	private static int findRoom(int i, int j, int nowValue, int cnt) {
		if(i>=0 && j>=0 && i<n && j<n) {
			if(arr[i][j] == nowValue) {
				int x = findRoom(i+1,j,nowValue+1,cnt+1);
				int y = findRoom(i-1,j,nowValue+1,cnt+1);
				int z = findRoom(i,j+1,nowValue+1,cnt+1);
				int w = findRoom(i,j-1,nowValue+1,cnt+1);
				
				cnt = Math.max(x, y);
				cnt = Math.max(cnt, z);
				cnt = Math.max(cnt, w);
			}
		}
		return cnt;
	}
}
