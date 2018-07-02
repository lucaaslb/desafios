package idwall.desafio.crawler;

public class Thread {
	
	private String subreddit;
	private String title; 
	private int upvotes; 
	private String url; 
	private String comments;
	
	
	public Thread(String subreddit, String title, int upvotes, String url, String comments) {
		this.subreddit = subreddit;
		this.title = title;
		this.upvotes = upvotes;
		this.url = url;
		this.comments = comments;
	}


	public String getSubreddit() {
		return subreddit;
	}


	@Override
	public String toString() {
		return  "Title: " + this.title 
				+ "Upvotes: " + this.upvotes 
				+ "URL: " + this.url 
				+ "Comments: " + this.comments;
	}
}
