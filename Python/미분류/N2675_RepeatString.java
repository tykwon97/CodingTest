import java.util.Scanner;

public class N2675_RepeatString {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String str = input.nextLine();
		str = str.trim(); //공백 제거
		//		str = str.replaceAll("\\s+", " "); // 연속된 공백 -> 하나의 공백으로      

		String[] strArray = str.split("\\s");

		if(!str.isBlank() ) {
			for(int i=0;i<strArray.length;i++) {
				System.out.println(strArray[i]);
			}

			System.out.println(strArray.length);
		}else {
			System.out.println("0");
		}
	}

}
