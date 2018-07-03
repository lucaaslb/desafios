package idwall.desafio;

import idwall.desafio.crawler.Crawler;
import idwall.desafio.crawler.Subreddit;

public class Main {

	private static final Integer TOPDAY = 5000;
	private static final String SUBREDDITS = "dog;cat;funny;worldnews";

	public static void main(String[] args) {
		int topday = TOPDAY;
		String subreddit = SUBREDDITS;

		switch (args.length) {
		case 1:
			subreddit = args[0];
			break;
		case 2:
			subreddit = args[0];
			topday = Integer.parseInt(args[1]);
			break;
		}
		
		Crawler rastrear = new Crawler();
		rastrear.search(subreddit, topday);
		
		Subreddit sr = rastrear.getSubreddit();
		System.out.println(sr.printAll(topday));
	}
}
