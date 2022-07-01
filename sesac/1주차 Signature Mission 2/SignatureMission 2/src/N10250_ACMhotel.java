import java.util.Scanner;

public class N10250_ACMhotel {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int t = input.nextInt();
		
		for(int i=0; i<t; i++) {
			int h = input.nextInt(); //Ãþ
			int w = input.nextInt(); //Ãþº° ¹æ¼ö
			int n = input.nextInt(); //¸î¹øÂ° ¼Õ´Ô
			
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
