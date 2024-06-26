package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2477_참외밭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int[] xCoordinates = new int[6];
        int[] yCoordinates = new int[6];

        st = new StringTokenizer(br.readLine(), " ");
        int dir = Integer.parseInt(st.nextToken()) - 1;
        int len = Integer.parseInt(st.nextToken());
        xCoordinates[0] = dx[dir] * len;
        yCoordinates[0] = dy[dir] * len;

        int[] xSortedCoordinates = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] ySortedCoordinates = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int i = 1; i < 6; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            dir = Integer.parseInt(st.nextToken()) - 1;
            len = Integer.parseInt(st.nextToken());

            xCoordinates[i] = xCoordinates[i - 1] + dx[dir] * len;
            yCoordinates[i] = yCoordinates[i - 1] + dy[dir] * len;

            boolean xFlag = true;
            for(int x : xSortedCoordinates){
                if(x == xCoordinates[i])
                    xFlag = false;
            }
            if(xFlag){
                if(xCoordinates[i] > xSortedCoordinates[0]){
                    xSortedCoordinates[2] = xSortedCoordinates[1];
                    xSortedCoordinates[1] = xSortedCoordinates[0];
                    xSortedCoordinates[0] = xCoordinates[i];
                }else if(xCoordinates[i] > xSortedCoordinates[1]){
                    xSortedCoordinates[2] = xSortedCoordinates[1];
                    xSortedCoordinates[1] = xCoordinates[i];
                }else if(xCoordinates[i] > xSortedCoordinates[2]){
                    xSortedCoordinates[2] = xCoordinates[i];
                }
            }

            boolean yFlag = true;
            for(int y : ySortedCoordinates){
                if(y == yCoordinates[i])
                    yFlag = false;
            }
            if(yFlag){
                if(yCoordinates[i] > ySortedCoordinates[0]){
                    ySortedCoordinates[2] = ySortedCoordinates[1];
                    ySortedCoordinates[1] = ySortedCoordinates[0];
                    ySortedCoordinates[0] = yCoordinates[i];
                }else if(yCoordinates[i] > ySortedCoordinates[1]){
                    ySortedCoordinates[2] = ySortedCoordinates[1];
                    ySortedCoordinates[1] = yCoordinates[i];
                }else if(yCoordinates[i] > ySortedCoordinates[2]){
                    ySortedCoordinates[2] = yCoordinates[i];
                }
            }
        }

        int answer = Math.abs(xSortedCoordinates[2] - xSortedCoordinates[0]) * Math.abs(ySortedCoordinates[2] - ySortedCoordinates[0]);

        int[] xFriends = {xSortedCoordinates[0], xSortedCoordinates[0], xSortedCoordinates[2], xSortedCoordinates[2]};
        int[] yFriends = {ySortedCoordinates[0], ySortedCoordinates[2], ySortedCoordinates[0], ySortedCoordinates[2]};

        for (int i = 0; i < 4; i++) {
            boolean flag = true;
            for (int j = 0; j < 6; j++) {
                if (xFriends[i] == xCoordinates[j] && yFriends[i] == yCoordinates[j]) {
                    flag = false; // 이미 좌표에 존재하는 경우
                    break;
                }
            }
            if (flag) {
                int temp = Math.abs(xFriends[i] - xSortedCoordinates[1]) * Math.abs(yFriends[i] - ySortedCoordinates[1]);
                answer -= temp;
                break;
            }
        }
        System.out.println(answer * k);
    }
}