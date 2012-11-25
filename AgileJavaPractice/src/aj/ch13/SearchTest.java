package aj.ch13;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class SearchTest {
	
	private static final String URL= "http://www.baidu.com";
	private static final String TEXT = "<head>";
	
	private Search search;
	
	@Before
	public void setUp(){
		search = new Search(URL,TEXT);
	}

	@Test
	public void testGetUrl() {
		assertEquals(URL,search.getUrl());
	}

	@Test
	public void testGetText() {
		assertEquals(TEXT,search.getText());
	}
	
	@Test
	public void testExcute() throws IOException{
		search.execute();
		assertEquals(1,search.getOccurrences());
	}
	

}
