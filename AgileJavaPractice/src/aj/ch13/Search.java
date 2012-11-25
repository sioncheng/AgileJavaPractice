package aj.ch13;

import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Search {
	
	private String url;
	private String text;
	private int occurrences;
	
	public String getUrl(){
		return this.url;
	}
	
	public String getText(){
		return this.text;
	}
	
	public int getOccurrences(){
		return this.occurrences;
	}

	public Search(String url,String text){
		this.url = url ;
		this.text = text;
		this.occurrences = 0;
	}
	
	public void execute() throws IOException{
		URL url;
		URLConnection connection;
		BufferedReader bufferedReader = null;
		
		try{
			url = new URL(this.url);
			connection = url.openConnection();
			
			InputStream inputStream = connection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
			
			String line = null ;
			while( (line = bufferedReader.readLine()) != null ){
				this.occurrences += StringUtil.occurrences(line, this.text);
			}
			
			
		}
		catch(MalformedURLException me){
			
		}
		catch(IOException ioe){
			
		}
		finally{
			if(bufferedReader != null){
				bufferedReader.close();
			}
		}
	}
}
