package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156_포도주시식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] wines = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        int[][] eatenWine = new int[n + 1][2];
        eatenWine[1][0] = wines[1];
        eatenWine[1][1] = 0;

        if (n > 1) {
            eatenWine[2][0] = wines[1] + wines[2];
            eatenWine[2][1] = wines[1];
        }
        if (n > 2) {
            eatenWine[3][0] = Math.max(wines[1], wines[2]) + wines[3];
            eatenWine[3][1] = wines[1] + wines[2];
        }

        for (int i = 4; i <= n; i++) {
            int temp;
            temp = Math.max(eatenWine[i - 3][0], eatenWine[i - 2][0]);
            temp = Math.max(temp, eatenWine[i - 2][1] + wines[i - 1]);

            eatenWine[i][0] = temp + wines[i];

            eatenWine[i][1] = Math.max(eatenWine[i-1][0], eatenWine[i-2][0]);
        }

        System.out.println(Math.max(eatenWine[n][0], eatenWine[n][1]));
    }
}
