import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N15552_FastAaddB {

	public static void main(String[] args) throws IOException { // BufferedReader�� ����ϱ� ���ؼ��� throws IOException�� �� �־�� ��.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //�Ҵ�� ���ۿ� �� �־��ֱ�
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // readLine���� ���� �Է� ������ String��.
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			bw.write(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + "\n");
		}
		
		br.close();
		bw.close();
	}

}
