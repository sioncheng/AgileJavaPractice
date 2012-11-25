package aj.ch8;

import org.junit.Test;
import static org.junit.Assert.*;

import aj.ch1.Student;
import aj.ch1.StudentNameFormatException;
import static aj.ch1.StudentNameFormatException.Reason;

import java.util.logging.*;

public class StudentNameFormatExceptionTest {

	@Test
	public void test(){
		try{
			Student student = new Student("A B");
			assertEquals("A B",student.getName());
		}
		catch(Exception e){
			Logger logger = Logger.getLogger(StudentNameFormatException.class.getName());
			logger.log(Level.ALL, e.toString());			

			StudentNameFormatException fe = (StudentNameFormatException)e;
			assertEquals(StudentNameFormatException.reasonToString(fe.getReason()),e.toString());
		}
	}
}
