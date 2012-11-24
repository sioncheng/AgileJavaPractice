package aj.ch2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import aj.ch1.Student;
import aj.util.DateUtil;

import java.util.Date;

public class CourseSessionTest{

	private CourseSession session;
	private Date startDate;
	
	@Before
	public void setUp(){
		startDate = DateUtil.createDate(2000, 1, 1);
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
		
		Date endDate = DateUtil.addDays(startDate, 17 * 6 - 3);
		assertEquals(endDate,session.getEndDate());
	}
}
