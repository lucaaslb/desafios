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

	public static Subreddit subreddit = new Subreddit();

	public void search(String reddit, int topday) {
		Thread thread;

		String subredditTitle;
		String title;
		int upvotes;
		String url;
		String comments;

		String[] link = reddit.split(";");

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
							subreddit.add(thread);
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
	
	

}
