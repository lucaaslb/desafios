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

	
	public String printAll(int top){		
		
		StringBuffer print = new StringBuffer(); 
		if (!this.isEmpty()) {
			for (Thread reddit: threads){
				print.append(reddit.toString());
			}
		} else {
			print.append("Não foi encontrado threads com pontuação maior ou igual a " + top + " na subreddit informada");
		}
						
		return print.toString();		
	}
	
}
