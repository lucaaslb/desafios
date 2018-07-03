/*
 *  Created by Lucas Lacerda (@lucaaslb) on 02/06/2018
 */

package idwall.desafio.crawler;

import java.util.ArrayList;


public class Subreddit {
	
	private ArrayList<Thread> threads = new ArrayList<Thread>(); 
	
	public void add(Thread thread) {
		threads.add(thread);		
	}
	
	public boolean isEmpty(){
		return threads.isEmpty();
	}

	
	public String printAll(){
		
		StringBuffer print = new StringBuffer(); 
		
		for (Thread reddit: threads){
			print.append(reddit.toString());
		}				
		return print.toString();		
	}
	
}
