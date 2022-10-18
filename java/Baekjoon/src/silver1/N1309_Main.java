package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1309_Main {
	public static int N;
	public static boolean[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		selected = new boolean[2*N];

		subset(0);
		System.out.println();
	}

	private static void subset(int index) {
		if(index == 2*N) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 2; j++) {
					if(selected[2*i+j]) {
						System.out.print("O ");
					}else {
						System.out.print("X ");						
					}
				}System.out.println();
			}
			System.out.println();
			return;
		}

		if(index>2) {
			if(!selected[0] && !selected[1]) //첫번째 줄에 사자가 없는 경우
				return;
		}

		if(index<=1) {
			selected[index] = true;
			subset(index+1);

			selected[index] = false;
			subset(index+1);
		}else {
			if(index%2 == 1) { //조건 걸기
				if(selected[index-1]) { //두번째 열일때 첫번재 열이 true인 경우
					selected[index] = false;
					subset(index+1);
				}else {
					selected[index] = true;
					subset(index+1);

					selected[index] = false;
					subset(index+1);
				}
			}else {

			}

			selected[index] = true;
			subset(index+1);

			selected[index] = false;
			subset(index+1);
		}





	}
}
