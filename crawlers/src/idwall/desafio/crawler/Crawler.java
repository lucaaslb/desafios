/*
 *  Created by Lucas Lacerda (@lucaaslb) on 02/06/2018
 */

package idwall.desafio.crawler;

import java.io.IOException;

import javax.xml.ws.http.HTTPException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Crawler {

	private Document doc = null;
	private final String urlMain = "https://old.reddit.com/r/";
	private final String urlTopDay = "/top/?t=day";

	private Subreddit subreddit = new Subreddit();

	
		
	 /**
     * Receives a string containing subreddits separated by ";" and a minimum upvote limit
     * the method will populate a threaded list of each subreddit informed.
     * To recover use getSubreddit()
     *      
     * @param subreddit 
     * @param topday  
     * 
     */
	public void search(String subreddit, int topday) {
		Thread thread;

		String subredditTitle;
		String title;
		int upvotes;
		String url;
		String comments;

		String[] link = subreddit.split(";");

		try {
			for (int i = 0; i < link.length; i++) {
				doc = Jsoup.connect(urlMain + link[i] + urlTopDay).get();

				Elements articles = doc.select("div.thing.link");

				for (Element article : articles) {

					Elements eUpvotes = article.select("div.thing.link div div[class=score unvoted]");

					if (!eUpvotes.attr("title").equalsIgnoreCase("")) {
						upvotes = Integer.parseInt(eUpvotes.attr("title"));

						if (upvotes >= topday) {
							Elements ePost = article.select("div.thing.link div div p a.title");
							Elements eComments = article.select("div.thing.link div div ul li a");
							
							subredditTitle = link[i].toUpperCase();
							title = ePost.text();
							url = ePost.attr("href");
							comments = eComments.attr("href");

							thread = new Thread(subredditTitle, title, upvotes, url, comments);
							this.subreddit.add(thread);
						}
					}
				}
			}

		} catch (IOException exc) {
			exc.printStackTrace();
		}  catch (NumberFormatException exc){
			exc.printStackTrace();
		}

	}



	public Subreddit getSubreddit() {
		return subreddit;
	}
	
	

}
