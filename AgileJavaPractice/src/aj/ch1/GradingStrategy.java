package aj.ch1;

public class GradingStrategy {
	
	public static int gradeToPoint(Student.Grade grade){
		if (grade == Student.Grade.A )
				return 5;
		if (grade == Student.Grade.B )
				return 4;
		if (grade ==  Student.Grade.C )
				return 3;
		if (grade ==  Student.Grade.D )
				return 2;
		if (grade == Student.Grade.E )
				return 1;
		
		return 0;
		
	}
}
