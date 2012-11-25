package aj.ch11;

import org.junit.Test;
import static org.junit.Assert.*;

import aj.ch2.CourseSession;
import aj.ch3.RosterReport;

import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.StringBuffer;

public class RosterReportFileTest {

	@Test
	public void testWriteReport() throws Exception{
		
		CourseSession session = new CourseSession("ENG","101");
		RosterReport report = new RosterReport(session);
		
		String filename = "/Users/Sion/Documents/roster-report.txt";
		report.writeReport(filename);
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		StringBuffer sb = new StringBuffer();
		String line;
		while( (line = br.readLine()) != null){
			sb.append(line);
			sb.append(RosterReport.NEW_LINE);
		}
		br.close();
		
		assertEquals(sb.toString(),RosterReport.getReport(session));
		
	}
}
