package aj.ch3;

import aj.ch1.Student;
import aj.ch2.CourseSession;

import java.lang.StringBuffer;

public class RosterReport {

	public static final String HEADER = "";
	public static final String FOOTER = "";
	public static final String NEW_LINE = System.getProperty("line.seperator");
	
	public static String getReport(CourseSession session){
		StringBuffer sb=new StringBuffer();
		
		sb.append(HEADER);
		sb.append(NEW_LINE);
		
		for(Student student : session.getStudents()){
			sb.append("student : ");
			sb.append(student.getName());
			sb.append(NEW_LINE);
		}

		sb.append(FOOTER);
		sb.append(NEW_LINE);
		
		return sb.toString();
	}
}
