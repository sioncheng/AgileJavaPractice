package aj.ch1;

import java.lang.RuntimeException;

public class StudentNameFormatException extends RuntimeException{

	public static final long serialVersionUID = 1L ;
	
	public static enum Reason { HasBlankSpace};
	
	
	private Reason reason;
	public Reason getReason(){
		return this.reason;
	}
	
	public StudentNameFormatException(StudentNameFormatException.Reason r){
		this.reason = r ;
	}
	
	@Override
	public String toString(){
		String r = reasonToString(this.reason);
		if(r.equals("")){
			return super.toString();
		}
		else{
			return r;
		}
	}
	
	public static String reasonToString(Reason reason){
		switch(reason){
			case HasBlankSpace :
				return "Student name shout not contain blank space";
			default:
				return "";
		}
	}
}
