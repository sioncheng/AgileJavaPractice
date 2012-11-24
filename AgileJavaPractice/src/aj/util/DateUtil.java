package aj.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	public static Date createDate(int year,int month,int day){
		Calendar calendar = new GregorianCalendar(year,month,day);
		return calendar.getTime();
	}
	
	public static Date addDays(Date date,int amount){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, amount);
		
		return calendar.getTime();
	}
	
	
}
