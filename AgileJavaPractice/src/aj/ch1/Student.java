package aj.ch1;

import java.util.ArrayList;

public class Student {

	public static enum Grade {A,B,C,D,E};
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private ArrayList<Grade> grades;
	
	public Student(String name){
		this.setName(name);
		this.grades = new ArrayList<Grade>();
	}
	
	public void addGrade(Grade grade){
		this.grades.add(grade);
	}
	
	public float getGpa(){
		if (this.grades.isEmpty()) {
			return 0.0f;
		}
		
		float r = 0.0f;		
		for(Grade grade : this.grades){
			r += GradingStrategy.gradeToPoint(grade);
		}
		
		return r / this.grades.size();
	}
	
}
