package silver1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class N1931_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int lastTime = Integer.MIN_VALUE;
		
		HashMap<Integer, String> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());	
			if(map.get(endTime) == null) {
				map.put(endTime, startTime+"");
			}else {
				map.replace(endTime, map.get(endTime)+" "+startTime);
			}
			
			if(endTime > lastTime)
				lastTime = endTime;
		}
		
		int[] dp = new int[lastTime+1];
		int min = 0;
		for(Integer key : map.keySet()) {
			int value = min;
			String nums = map.get(key);
			String[] indexes = nums.split(" ");
			for (int i = 0; i < indexes.length; i++) {
				int index = Integer.parseInt(indexes[i]);
				int v = dp[index] + 1;
				if(v>value)
					value = v;				
			}
			dp[key] = value;
			min = value;
		}
		
		int maxValue = Integer.MIN_VALUE;
		for (int i = 1; i < dp.length; i++) {
			if(maxValue<dp[i])
				maxValue = dp[i];
		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(maxValue);
		
	}
}
