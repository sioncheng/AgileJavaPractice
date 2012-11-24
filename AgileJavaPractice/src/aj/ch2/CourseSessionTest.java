package aj.ch2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import aj.ch1.Student;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CourseSessionTest{

	private CourseSession session;
	private GregorianCalendar startDateCalendar;
	private Date startDate;
	
	@Before
	public void setUp(){
		startDateCalendar = new GregorianCalendar(2012,1,1);
		startDate = startDateCalendar.getTime();
		session = new CourseSession("ENG","100",startDate);
	}
	
	
	@Test
	public void testCreate(){
		assertEquals("ENG",session.getDepartment());
		assertEquals("100",session.getNumber());
		assertEquals(0,session.getNumberOfStudents());
		assertEquals(startDate,session.getStartDate());
	}

	@Test
	public void testEnroll(){
		Student student1 = new Student("Jon");
		session.enroll(student1);
		Student student2 = new Student("Joy");
		session.enroll(student2);
		
		assertEquals(2,session.getNumberOfStudents());
		assertEquals(student1,session.getStudent(0));
		assertEquals(student2,session.getStudent(1));
		
		startDateCalendar.add(Calendar.DAY_OF_YEAR, 17 * 6 - 3);
		Date endDate = startDateCalendar.getTime();
		assertEquals(endDate,session.getEndDate());
	}
}
