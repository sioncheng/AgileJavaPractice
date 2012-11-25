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
	private int matches;
	
	public String getUrl(){
		return this.url;
	}
	
	public String getText(){
		return this.text;
	}
	
	public int getMatches(){
		return this.matches;
	}

	public Search(String url,String text){
		this.url = url ;
		this.text = text;
		this.matches = 0;
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
				this.matches += StringUtil.occurrences(line, this.text);
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
