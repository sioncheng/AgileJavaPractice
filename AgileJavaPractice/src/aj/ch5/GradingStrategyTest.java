package aj.ch5;

import aj.ch1.Student;

import org.junit.Test;
import org.junit.Assert;

public class GradingStrategyTest {

	@Test
	public void testGradeToPoint(){
		Student student = new Student("Jon");
		student.addGrade(Student.Grade.A);
		student.addGrade(Student.Grade.B);
		
		Assert.assertEquals(4.5f, student.getGpa(), 0.05);
		Assert.assertEquals(4.5f, 4.49f, 0.5f);
	}
}
