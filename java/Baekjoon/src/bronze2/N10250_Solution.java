package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N10250_Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int t = input.nextInt();
		
		for(int i=0; i<t; i++) {
			int h = input.nextInt(); //층
			int w = input.nextInt(); //층별 방수
			int n = input.nextInt(); //몇번째 손님
			
			int floor = (n-1)%h+1;
			int room = (n-1)/h+1;
			String roomNum = "";
			if(room<10) {
				roomNum = floor +"0"+ room;	
			}else {
				roomNum = floor +""+ room;
			}
			System.out.println(roomNum);
		}
	}

}