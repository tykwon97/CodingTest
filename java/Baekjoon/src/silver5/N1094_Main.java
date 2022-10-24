package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1094_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine()); 
			
		int result = stick(n);
			
		System.out.println(result);
	}

	private static int stick(int n) {
		int cnt = 0; //총 필요한 막대기 개수
		
		int size = -1; //남은 막대기 길이
		
		// 막대기 시작 크기 정하기
		for (int i = 0; i <= 6; i++) {
			size = 1<<i;
			if(size == n) { // 바로 만들 수 있는 경우
				return 1;
			}else if(size > n) {
				break;				
			}
		}
		
		while(size>0) {
			size = size/2; // 막대기는 절반씩 나눈다.
			// size>n인 경우 버린다.
			if(size == n) { //딱 맞는 경우
				cnt++;
				break;
			}else if(size < n) { //필요한 막대기 크기만 빼고 계속 구한다.
				cnt++;
				n -= size;
			}
		}
		
		return cnt;
	}
}