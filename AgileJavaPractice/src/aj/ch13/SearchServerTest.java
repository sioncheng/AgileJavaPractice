package aj.ch13;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchServerTest {

	private int finishedNumber;
	
	@Test
	public void test() throws Exception{
		
		Search search1 = new Search("http://www.baidu.com","<head>");
		Search search2 = new Search("http://www.douban.com","<body>");
		Search search3 = new Search("http://www.bing.com","<html>");
		
		finishedNumber = 0 ;
		
		ResultListener listener = new ResultListener(){
			public void execute(Search search){
				finishedNumber += 1;
				System.out.println(search.getUrl() + " " + search.getText() + " " + search.getMatches());
			}
		};
		
		SearchServer searchServer = new SearchServer(listener);
		searchServer.addSearch(search1);
		searchServer.addSearch(search2);
		searchServer.addSearch(search3);
		
		while(finishedNumber < 3){
			Thread.sleep(100);
		}
		
		assertEquals(3,finishedNumber);
	}

}
