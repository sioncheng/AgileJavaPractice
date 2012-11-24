package aj.ch1;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		Student student1 = new Student("Jon");
		assertEquals("Jon",student1.getName());
		
		Student student2 = new Student("Joy");
		assertEquals("Joy",student2.getName());
	}

}
