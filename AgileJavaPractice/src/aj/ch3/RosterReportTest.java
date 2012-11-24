package aj.ch3;

import static org.junit.Assert.*;

import org.junit.Test;

import aj.ch1.Student;
import aj.ch2.CourseSession;

import java.lang.StringBuffer;

public class RosterReportTest {

	@Test
	public void test() {
		CourseSession session = new CourseSession("ENG","100");
		session.enroll(new Student("Jon"));
		session.enroll(new Student("Joy"));
		
		StringBuffer sb = new StringBuffer();
		sb.append(RosterReport.HEADER);
		sb.append(RosterReport.NEW_LINE);
		for(Student student : session.getStudents()){
			sb.append("student : ");
			sb.append(student.getName());
			sb.append(RosterReport.NEW_LINE);
		}
		sb.append(RosterReport.FOOTER);
		sb.append(RosterReport.NEW_LINE);
		
		assertEquals(sb.toString(),RosterReport.getReport(session));
		
		System.out.print(sb.toString());
	}

}
