package bronze5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class N4101_Solution {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		String newDate = simpleDateFormat.format(date); 
		System.out.println(newDate);
		
	}
}
