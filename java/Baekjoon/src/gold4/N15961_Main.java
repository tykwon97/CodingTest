package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
<<<<<<< HEAD
import java.util.StringTokenizer;

public class N15961_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

=======
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class N15961_Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
>>>>>>> bc81e5d4eea65c829b1d3967109350b270c9e36d
		//회전 초밥 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
<<<<<<< HEAD
		int maxValue = Integer.MIN_VALUE;

=======
>>>>>>> bc81e5d4eea65c829b1d3967109350b270c9e36d
		int[] list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(in.readLine());
		}
<<<<<<< HEAD

=======
		
>>>>>>> bc81e5d4eea65c829b1d3967109350b270c9e36d
		boolean[] isSelected = new boolean[D+1];
		int len = 0;
		for (int i = 0; i < K; i++) {
			int num = list[i];
			if(!isSelected[num]) {
				len++;
				isSelected[num] = true;
			}
		}
<<<<<<< HEAD

		//			System.out.print("시작 select : ");
		//			for (int j = 0; j < D+1; j++) {
		//				if(isSelected[j])
		//					System.out.print(j+" ");
		//			}
		//			System.out.println();
		//			System.out.println(" len : "+len);

		if(!isSelected[C]) {
			if(maxValue<len+1)
				maxValue = len+1;
		}else {
			if(maxValue<len)
				maxValue = len;
		}

		for (int i = K; i < N; i++) {
			int now = list[i]; // 추가 되는 것
			int prev = list[i-K]; // 삭제 되는 것

			//				System.out.print("select : ");
			//				for (int j = 0; j < D+1; j++) {
			//					if(isSelected[j])
			//						System.out.print(j+" ");
			//				}
			//				System.out.println();

=======
		
//		System.out.print("시작 select : ");
//		for (int j = 0; j < D+1; j++) {
//			if(isSelected[j])
//				System.out.print(j+" ");
//		}
//		System.out.println();
//		System.out.println(" len : "+len);
		
		if(len==K && !isSelected[C]) {
			System.out.println(K+1);
			return;
		}	
		
		for (int i = K; i < N; i++) {
			int now = list[i]; // 추가 되는 것
			int prev = list[i-K]; // 삭제 되는 것
			
//			System.out.print("select : ");
//			for (int j = 0; j < D+1; j++) {
//				if(isSelected[j])
//					System.out.print(j+" ");
//			}
//			System.out.println();
			
>>>>>>> bc81e5d4eea65c829b1d3967109350b270c9e36d
			boolean flag=true; // 삭제하는 것과 이미 존재하는게 같은지
			for (int j = 0; j < K-1; j++) {
				int temp = list[i-j];
				if(prev == temp)
					flag = false;
			}
			if(flag) {
				isSelected[prev] = false;
				len--;
			}
			if(isSelected[now]) { // 새로 추가하는 것이이미 존재하는 경우
				continue;
			}else {
				isSelected[now] = true;
				len++;
<<<<<<< HEAD
				//					System.out.println("now : "+now+" len : "+len);
			}

			if(!isSelected[C]) {
				if(maxValue<len+1)
					maxValue = len+1;
			}else {
				if(maxValue<len)
					maxValue = len;
			}	
		}

		for (int i = 0; i < K; i++) {
			int now = list[i]; // 추가 되는 것
			int prev = list[N-K+i]; // 삭제 되는 것

=======
//				System.out.println("now : "+now+" len : "+len);
			}
			
			if(len==K && !isSelected[C]) {
				System.out.println(K+1);
				return;
			}		
		}
		
		for (int i = 0; i < K-1; i++) {
			int now = list[i]; // 추가 되는 것
			int prev = list[N-K+i]; // 삭제 되는 것
			
>>>>>>> bc81e5d4eea65c829b1d3967109350b270c9e36d
			boolean flag=true; // 삭제하는 것과 이미 존재하는게 같은지
			for (int j = 0; j < K-1-i; j++) {
				int temp = list[N-1-j];
				if(prev == temp)
					flag = false;
			}
			for (int j = 0; j < i; j++) {
				int temp = list[j];
				if(prev == temp)
					flag = false;
			}
			if(flag) {
				isSelected[prev] = false;
				len--;
			}
<<<<<<< HEAD
=======
			
>>>>>>> bc81e5d4eea65c829b1d3967109350b270c9e36d
			if(isSelected[now]) { // 새로 추가하는 것이이미 존재하는 경우
				continue;
			}else {
				isSelected[now] = true;
				len++;
			}
<<<<<<< HEAD

			if(!isSelected[C]) {
				if(maxValue<len+1)
					maxValue = len+1;
			}else {
				if(maxValue<len)
					maxValue = len;
			}	
		}
		System.out.println(maxValue);
=======
			
			if(len==K && !isSelected[C]) {
				System.out.println(K+1);
				return;
			}		
		}
		System.out.println(K);
>>>>>>> bc81e5d4eea65c829b1d3967109350b270c9e36d
	}
}
