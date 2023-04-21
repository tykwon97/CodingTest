package silver3;

import java.util.*;
import java.io.*;

public class N8911_Main {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(in.readLine());

		for(int i = 0; i < num; i++) {
			int minX = 0;
			int minY = 0;
			int maxX = 0;
			int maxY = 0;

			int[] dx = {1,0,-1,0};
			int[] dy = {0,1,0,-1};

			int direction = 0; // 0:위 1:왼쪽 2:아래 3:오른쪽

			int x = 0;
			int y = 0;

			char[] moves = in.readLine().toCharArray();
			
			for(char move : moves) {
				if(move == 'F') {
					x += dx[direction];
					y += dy[direction];
				}else if(move == 'B') {
					x -= dx[direction];
					y -= dy[direction];
				}else if(move == 'L') {
					direction = (direction + 1) % 4;
				}else if(move == 'R') {
					direction = direction - 1;
					if(direction == -1)
						direction = 3;
				}

				if(minX > x) {
					minX = x;
				}
				if(minY > y) {
					minY = y;
				}

				if(maxX < x) {
					maxX = x;
				}
				if(maxY < y) {
					maxY = y;
				}
			}

			sb.append(Math.abs(maxX-minX) * Math.abs(maxY-minY)).append("\n");
		}

		System.out.println(sb);
	}
}
