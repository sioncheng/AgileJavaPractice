package aj.ch2;

import aj.ch1.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CourseSession {

	private String department;
	private String number;
	private ArrayList<Student> students = new ArrayList<Student>();
	private Date startDate;
	
	public CourseSession(String department,String number){
		this.department = department;
		this.number = number;
	}
	
	public CourseSession(String department,String number,Date startDate){
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}
	
	public String getDepartment(){
		return this.department;
	}
	
	public String getNumber(){
		return this.number;
	}
	
	public int getNumberOfStudents(){
		return this.students.size();
	}
	
	public void enroll(Student student){
		this.students.add(student);
	}
	
	public Student getStudent(int index){
		return this.students.get(index);
	}
	
	public Date getStartDate(){
		return this.startDate;
	}
	
	public Date getEndDate(){
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		int days = 17 * 6 - 3;
		calendar.add(Calendar.DAY_OF_YEAR, days);
		
		return calendar.getTime();
	}
}
