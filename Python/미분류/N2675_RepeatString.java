import java.util.Scanner;

public class N2675_RepeatString {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String str = input.nextLine();
		str = str.trim(); //���� ����
		//		str = str.replaceAll("\\s+", " "); // ���ӵ� ���� -> �ϳ��� ��������      

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
