package practicehome;

import java.time.LocalDateTime;

public class BookTicketForTodayTest {

	public static void main(String[] args) {
				
			LocalDateTime dateandtime=LocalDateTime.now();
			String month = dateandtime.getMonth().toString();
			int year = dateandtime.getYear();
			int date = dateandtime.getDayOfMonth();
			String actualmonth = month.substring(0,1)+month.substring(1).toLowerCase();
			 String monthandyear = actualmonth+" "+year;
			 System.out.println(monthandyear);
	}

}
