package kakao2022_2;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
	public static void main(String[] args) {
//		int[][] users = {{40, 10000}, {25, 10000}};
		int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
//		int[] emoticons = {7000, 9000};
		int[] emoticons  = {1300, 1500, 1600, 4900};
		solution(users,emoticons);
	}

	public static int[][] user;
	public static int[] emoticon;
	public static int maxCount = Integer.MIN_VALUE;
	public static int maxTotal = Integer.MIN_VALUE;
	
	public static int[] solution(int[][] users, int[] emoticons) {
		user = users;
		emoticon = emoticons;
		int len = users.length;
		int[] arr = {4,3,2,1};
		int[] out = new int[len];
		permutation(arr, out, 0, len);
		int[] answer = {maxCount,maxTotal};
		return answer;
	}

	public static void permutation(int[] arr, int[] out, int depth, int r){
		if(depth == r){
        	int count = 0;
        	int total = 0;
        	int len = user.length;
        	for (int i = 0; i < len; i++) {
        		int discount = user[i][0];
        		int limit = user[i][1];
        		
                int x = len-i;
        		if(maxCount>count+x)
        			return;

        		int t = 0;
        		int elen = emoticon.length;
        		for (int j = 0; j < elen; j++) { //한 사람
					if(out[j]*10 >= discount) {
						t += (emoticon[j]*(10-out[j])*0.1);
					}
                    if(t >= limit){
        			    count++;
                        break;
                    }
				}
        		if(t < limit) {
        			total += t;
        		}
			}
            if(count > maxCount) {
            	maxCount = count;
            	maxTotal = total;
            }else if(count == maxCount && maxTotal < total) {
            	maxTotal = total;
            }
//        	System.out.println(Arrays.toString(out));
            return;
        }
        for(int i=0; i<arr.length; i++){
            out[depth] = arr[i];
            permutation(arr, out, depth+1, r);
        }
    }
}
