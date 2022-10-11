package a01_diexp.z10_vo;

import org.springframework.stereotype.Component;

@Component
public class Pen {
	private String kind;
	private int price;
	private String color;
	public Pen() {
		// TODO Auto-generated constructor stub
	}
	public Pen(String kind, int price, String color) {
		super();
		this.kind = kind;
		this.price = price;
		this.color = color;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
