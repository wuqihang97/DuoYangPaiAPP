package cn.tedu.wqhtest.entity;

public class Capsule {
	private int icon;
	private String subtitle;
	private String theme;
	private String detail;

	public Capsule() {

	}

	public Capsule(int icon, String subtitle, String theme, String detail) {
		super();
		this.icon = icon;
		this.subtitle = subtitle;
		this.theme = theme;
		this.detail = detail;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
