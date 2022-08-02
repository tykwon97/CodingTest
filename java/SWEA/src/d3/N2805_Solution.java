package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2805_Solution {
	
	public static void farm(int x, int y, int nowCnt) {
		if(x<0 || y<0 || x>count*2-1 || y>count*2-1) {
			return;
		}
		if(nowCnt == count) {
			return;
		}
//		System.out.println(x+" "+y +" nowCnt : "+nowCnt + "cnt : "+count +" arr[x][y] : "+(arr[x][y]-'0'));
		if(arr[x][y] != '9') { //가치가 아닌 숫자로 변경
			total += arr[x][y]-'0';
			arr[x][y] = '9';
		}
		
		farm(x+1,y,nowCnt+1);
		farm(x,y+1,nowCnt+1);
		farm(x,y-1,nowCnt+1);
		farm(x-1,y,nowCnt+1);
		
	}
	
	public static int total;
	public static int count;
	public static char[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=cnt; tc++) {
			int num = Integer.parseInt(in.readLine());
			
			arr = new char[num][num];
			for(int i=0; i<num; i++) {
				arr[i] = in.readLine().toCharArray();
			}
			total = 0;
			count = num/2+1;
			//farm(num/2, num/2, 0);
			
			for(int i=0; i<=num/2; i++) {
				for(int j=num/2-i; j<=num/2+i; j++) {
					total += arr[i][j] -'0';
				}
			
			}
			
			for(int i=num/2+1; i<num; i++) {
				int reali = i-num/2;
				for(int j=reali; j<num-reali; j++) {
//					System.out.println(i+" "+j);
					total += arr[i][j] - '0';
				}
			}
			
			System.out.println("#"+tc+" "+total);
		}
	}
}
