package aj.ch13;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testOccurrences() {
		assertEquals(1,StringUtil.occurrences("abc", "a"));
		assertEquals(1,StringUtil.occurrences("abc", "ab"));
		assertEquals(1,StringUtil.occurrences("abc", "bc"));
		assertEquals(1,StringUtil.occurrences("abc", "abc"));

		assertEquals(0,StringUtil.occurrences("abc", "ac"));
		assertEquals(5,StringUtil.occurrences("aaaaa", "a"));

		assertEquals(5,StringUtil.occurrences("ababababab", "ab"));
	}

}
