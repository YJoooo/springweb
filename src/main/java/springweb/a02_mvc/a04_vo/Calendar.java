package springweb.a02_mvc.a04_vo;
// springweb.a02_mvc.a04_vo.Calendar
public class Calendar {
	private int id;
	private String title;
	private String start;
	private String end;
	private String content;
	private String borderColor;
	private String backgroundColor;
	private String textColor;
	private boolean allDay;
	public Calendar() {
		// TODO Auto-generated constructor stub
	}
	public Calendar(int id, String title, String start, String end, String content, String borderColor,
			String backgroundColor, String textColor, boolean allDay) {
		super();
		this.id = id;
		this.title = title;
		this.start = start;
		this.end = end;
		this.content = content;
		this.borderColor = borderColor;
		this.backgroundColor = backgroundColor;
		this.textColor = textColor;
		this.allDay = allDay;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	public boolean isAllDay() {
		return allDay;
	}
	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}


}
