package aj.ch3;

import aj.ch1.Student;
import aj.ch2.CourseSession;

import java.lang.StringBuffer;
import java.util.ArrayList;
import java.util.Collections;

public class RosterReport {

	public static final String HEADER = "";
	public static final String FOOTER = "";
	public static final String NEW_LINE = System.getProperty("line.seperator");
	
	private ArrayList<CourseSession> sessions ;
	
	public RosterReport(){
		this.sessions = new ArrayList<CourseSession>();
	}
	
	public void add(CourseSession session){
		this.sessions.add(session);
	}
	
	public String text(){

		Collections.sort(this.sessions);
		StringBuffer sb = new StringBuffer () ;
		for(CourseSession session : this.sessions){
			sb.append("department ");
			sb.append(session.getDepartment());
			sb.append(" ");
			sb.append("number ");
			sb.append(session.getNumber());
			sb.append(NEW_LINE);
		}
		
		return sb.toString();
	}
	
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
