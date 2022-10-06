package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class N5539_Solution {
	public static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[9][9];
		for (int i = 0; i < 9; i++) {
			map[i] = in.readLine().toCharArray();
		}

		sdoku();

	}

	private static void sdoku() {
		boolean flag = true;
		while(flag) {
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					
				}
			}
			
			
			
			
			
			
		}
		
		
	}



	
}
