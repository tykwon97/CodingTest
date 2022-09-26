package kakao2022_2;

public class Main2 {
	public static void main(String[] args) {
		int cap = 2;
		int n = 7;
//		int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
//		int[] pickups = {0, 2, 0, 1, 0, 2, 0};
		int[] deliveries = {0, 0, 0, 0, 0, 0, 0};
		int[] pickups = {2, 2, 2, 1, 0, 2, 0};
		solution( cap,  n,  deliveries,  pickups);
	}
	
	public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;
        answer = 0;
        int len = deliveries.length-1;
        int dindex = len;
        int pindex = len;
        
        for (int i = len; i >= 0; i--) {
			dindex = i;
			if(deliveries[i] !=0) {
				break;
			}
		}
        
        for (int i = len; i >= 0; i--) {
			pindex = i;
			if(pickups[i] !=0) {
				break;
			}
		}
        
        while(dindex != -1 || pindex != -1) {
            System.out.println(dindex+ ":  "+pindex);
        	if(dindex == 0 && deliveries[0]==0)
        		dindex = -1;
        	if(pindex == 0 && pickups[0]==0)
        		pindex = -1;
        	answer += Math.max(dindex+1,pindex+1)*2;
        	int dcap = cap;
        	boolean flag = true;
        	for (int i = dindex; i >= 0; i--) {
				dindex = i;
    			if(deliveries[i] !=0) {
    				if(flag) {
    					if(deliveries[i] > dcap) {
    						deliveries[i] -= dcap;
        					break;
        				}else if(deliveries[i] == dcap){
        					deliveries[i] -= dcap;
        					flag = false;
        				}else {
        					dcap -= deliveries[i];
        					deliveries[i] = 0;
        				}
    				}else {
    					break;
    				}
    			}
    		}
        	
        	int pcap = cap;
        	flag = true;
        	for (int i = pindex; i >= 0; i--) {
				pindex = i;
    			if(pickups[i] !=0) {
    				if(flag) {
    					if(pickups[i] > pcap) {
        					pickups[i] -= pcap;
        					break;
        				}else if(pickups[i] == pcap){
        					pickups[i] -= pcap;
        					flag = false;
        				}else {
        					pcap -= pickups[i];
        					pickups[i] = 0;
        				}
    				}else {
    					break;
    				}
    				
    			}
    		}
            System.out.println(dindex+ ":  "+pindex);
        }
        System.out.println(answer);
        return answer;
    }
}
