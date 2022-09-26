package kakao2022_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1 {

	public static void main(String[] args) {
//		String today = "2022.05.19";
		String today = "2020.01.01";
//		String[] terms = {"A 6", "B 12", "C 3"};
		String[] terms = {"Z 3", "D 5"};
//		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
		
		solution(today,terms,privacies);
	}	
	
	public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> list = new LinkedList<Integer>();
        StringTokenizer st = new StringTokenizer(today, ".");
    	int yy = Integer.parseInt(st.nextToken());
    	int mm = Integer.parseInt(st.nextToken());
    	int dd = Integer.parseInt(st.nextToken());
        int i=0;
        for(String day : privacies) {
        	i++;
        	st = new StringTokenizer(day, " ");
        	String s = st.nextToken();
        	String op = st.nextToken();

        	st = new StringTokenizer(s, ".");
        	int y = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	
        	for (int j = 0; j < terms.length; j++) {
            	st = new StringTokenizer(terms[j], " ");
            	String opt = st.nextToken();
            	if(op.equals(opt)) {
            		int x = Integer.parseInt(st.nextToken())-1;
            		d += 27;
            		if(d>28) {
            			d-=28;
            			m+=1;
            		}
            		m += x;
            		if(m>12) {
            			int k = m-1/12;
                		y+=k;
                		m-=12*k;
            		}
            		break;
            	}
				
			}
        	if(yy>y) {
        		list.add(i);
        		continue;
        	}else if(yy==y) {
        		if(mm>m){
        			list.add(i);
        			continue;
        		}else if(mm==m) {
        			if(dd>d) {
        				list.add(i);
        				continue;
        			}
        		}
        	}
        	
        }
        answer = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
        	answer[j] = list.get(j);
		}
        
        System.out.println(Arrays.toString(answer));
        
        return answer;
    }
}
