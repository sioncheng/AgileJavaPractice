package aj.ch2;

import aj.ch1.Student;
import aj.util.DateUtil;

import java.util.ArrayList;
import java.util.Date;

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
		return DateUtil.addDays(this.startDate, 17 * 6 - 3);
	}
	
	public ArrayList<Student> getStudents(){		
		ArrayList<Student> al = new ArrayList<Student>(this.getNumberOfStudents());
		al.addAll(this.students);
		return al;
	}
}
