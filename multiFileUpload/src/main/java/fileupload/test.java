package fileupload;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class test {
	public static void main(String[] args) {
		java.util.Date utilDate = new java.util.Date();
		long currentMillSeconds = utilDate.getTime();
		
		java.sql.Date sqlDate = new java.sql.Date(currentMillSeconds);
		LocalDateTime today = LocalDateTime.now();

		System.out.println("utilDate = " + utilDate);
		System.out.println("sqlDate = " + sqlDate);
		System.out.println("today = " + today);
		System.out.println("today = " + LocalDate.now());
		
		LocalTime time = LocalTime.now();
		
		System.out.println("time = " + time.toString().substring(0,8));
		
	}
}
