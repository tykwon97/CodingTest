package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1309_Main2 {
	public static int N;
	public static int cnt;
	public static boolean[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		selected = new boolean[2*N];

		subset(0);
		
//		System.out.println("정답");
		System.out.println(cnt%9901);
	}

	private static void subset(int index) {
			if(index == 2*N) {
	//			for (int i = 0; i < N; i++) {
	//				for (int j = 0; j < 2; j++) {
	//					if(selected[2*i+j]) {
	//						System.out.print("O ");
	//					}else {
	//						System.out.print("X ");						
	//					}
	//				}System.out.println();
	//			}
	//			System.out.println();
			cnt++;
			return;
		}
		
		if(index==0) {
			selected[index] = true;
			subset(index+1);

			selected[index] = false;
			subset(index+1);
		}else {

			boolean flag = false; //근처에 존재 하는 경우 체크
			
			// 바로 위 체크
			if(index>=2 && selected[index-2])
				flag = true;
			
			if(index%2 == 1) { // 오른쪽일때		
				// 왼쪽 체크
				if(index>=1 && selected[index-1])
					flag = true;
			}
			
			if(flag) { //근처에 있는 경우
				selected[index] = false;
				subset(index+1);
			}else {
				selected[index] = true;	
				subset(index+1);

				selected[index] = false;
				subset(index+1);
			}
		}
	}
}
