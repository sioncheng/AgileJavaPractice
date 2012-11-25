package aj.ch3;

import static org.junit.Assert.*;

import org.junit.Test;

import aj.ch1.Student;
import aj.ch2.CourseSession;

import java.lang.StringBuffer;

public class RosterReportTest {

	@Test
	public void testGetReport() {
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
	
	@Test
	public void testText(){
		RosterReport report = new RosterReport();
		report.add(new CourseSession("ENG","100"));
		report.add(new CourseSession("MTH","90"));
		report.add(new CourseSession("PHY","102"));
		
		StringBuffer sb = new StringBuffer();
		sb.append("department ENG number 100");
		sb.append(RosterReport.NEW_LINE);
		sb.append("department PHY number 102");
		sb.append(RosterReport.NEW_LINE);
		sb.append("department MTH number 90");
		sb.append(RosterReport.NEW_LINE);
		
		assertEquals(sb.toString(),report.text());
	}

}
