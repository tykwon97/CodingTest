package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1210_Solution2 {
	
	static int ladder[][] = new int[100][100];
	
	public static int ladderGame(int x, int y, int prevy) {
		if(x == 0 && ladder[x][y] == 1)
			return y;
		if(x == 0)
			return -1;
		if(y-1 >=0) {
			if(ladder[x][y-1] == 1 && y-1!=prevy)
				return ladderGame(x,y-1,y);
		}
		if(y+1 <100) {
			if(ladder[x][y+1] == 1 && y+1!=prevy)
				return ladderGame(x,y+1,y);
		}
		
		return ladderGame(x-1,y,-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1; tc<=10; tc++) {
			String num = in.readLine(); //사용 안함
			for(int i=0; i<100; i++) {
				String arr[] = in.readLine().split(" ");
				for(int j=0 ;j<100; j++)
					ladder[i][j] = Integer.parseInt(arr[j]);
			}
			int check = -1;
			for(int j=0; j<100; j++) {
				if(ladder[99][j] == 2) {
					check = ladderGame(99,j,-1);
					break;
				}
			}
			
			System.out.println("#"+tc+" "+check);
		}
	}
}