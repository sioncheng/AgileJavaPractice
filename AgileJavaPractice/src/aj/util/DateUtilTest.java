package aj.util;

import  org.junit.Assert;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class DateUtilTest{
	
	private Date date;
	
	@Before
	public void setUp(){
		Calendar calendar = new GregorianCalendar(2000,1,1);
		date = calendar.getTime();
	}
	
	@Test
	public void testCreateDate(){
		Date createdDate = DateUtil.createDate(2000, 1, 1);
		Assert.assertEquals(date,createdDate);
	}
	
	@Test
	public void testAddDays(){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, 100);
		
		Assert.assertEquals(calendar.getTime(), DateUtil.addDays(date, 100));
	}
}