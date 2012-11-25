package aj.ch13;

import java.lang.Thread;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.io.IOException;
import java.lang.InterruptedException;

public class SearchServer extends Thread {
	
	private ResultListener resultListener;
	private BlockingDeque<Search> searchs;
	
	public SearchServer(ResultListener resultListener){
		this.resultListener = resultListener;
		this.searchs = new LinkedBlockingDeque<Search>();
		this.start();
	}
	
	public void addSearch(Search search){
		this.searchs.add(search);
	}

	public void run(){
		while(!this.searchs.isEmpty()){
			try{
				Search search = this.searchs.take();
				search.execute();
				if(this.resultListener != null){
					this.resultListener.execute(search);
				}
				
			}
			catch(IOException ioe){
				
			}
			catch(InterruptedException ie){
				
			}
		}
		
		Thread.yield();
	}
}
