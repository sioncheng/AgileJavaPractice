package aj.ch3;

import aj.ch1.Student;
import aj.ch2.CourseSession;

import java.lang.StringBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class RosterReport {

	public static final String HEADER = "==== header =====";
	public static final String FOOTER = "==== footer =====";
	public static final String NEW_LINE = System.getProperty("line.separator");
	
	private ArrayList<CourseSession> sessions ;
	
	public RosterReport(){
		this.sessions = new ArrayList<CourseSession>();
	}
	
	public RosterReport(CourseSession session){
		this();
		this.add(session);
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
	
	public void writeReport(String filename) throws Exception{
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		String text = getReport(this.sessions.get(0));
		writer.write(text,0,text.length());
		writer.close();
	}
	
}
