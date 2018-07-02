package idwall.desafio;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) {

		Document doc = null;

		String[] links = { "/r/dog", /*"/r/cat", "/r/AskReddit",*/};

		String urlMain = "https://old.reddit.com";

		try {
			for (int i = 0; i < links.length; i++) {
				doc = Jsoup.connect(urlMain + links[i] + "/top/?t=day").get();

				String title = doc.title();
				Elements subreddit = doc.select("div.thing.link");
	
				System.out.println("Page title: " + title);

				for (Element thread : subreddit) {
	
				Elements upvotes = thread.select("div.thing.link div div[class=score unvoted]");				
				Elements post = thread.select("div.thing.link div div p a.title");	
				Elements comments = thread.select("div.thing.link div div ul li a");	
				
				System.out.println("Score: " + upvotes.text());		
				System.out.println("Post title: " + post.text());
				
				System.out.println("Post link: " + post.attr("href"));
				System.out.println("Comments: " + comments.attr("href"));
				System.out.println();

				}
			}

		} catch (IOException exc) {
			exc.printStackTrace();
		}

	}

}
