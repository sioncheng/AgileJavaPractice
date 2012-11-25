package aj.ch13;

public class StringUtil {

	public static int occurrences(String string,String subString){
		int occurrences = 0 ;
		
		for(int i = 0 ; i < string.length(); ){
			if(string.regionMatches(true, i, subString, 0, subString.length())){
				occurrences += 1;
				i += subString.length();
			}
			else{
				++i;
			}
		}
		
		return occurrences;
	}
}
