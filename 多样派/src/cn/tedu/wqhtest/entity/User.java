package cn.tedu.wqhtest.entity;

public class User {
	private int icon;
	private String name;
	private String news;
	private String time;
	private String amount;

	public User() {
	}

	public User(int icon, String name, String news, String time, String amount) {
		super();
		this.icon = icon;
		this.name = name;
		this.news = news;
		this.time = time;
		this.amount = amount;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
