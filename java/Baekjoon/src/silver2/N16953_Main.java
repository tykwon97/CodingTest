package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N16953_Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(in.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int index = B;
        int cnt = 1;
        
        while(A < index) {
        	if(index%10 == 1) {
        		index = index/10;
        		cnt++;
        	}else if(index%2==0 && index/2>0) {
        		index = index/2;
        		cnt++;
        	}
        	if(index == A)
        		break;
        }
        
        if(index<A) {
        	System.out.println("-1");
        }else {
        	System.out.println(cnt);
        }
    }
}