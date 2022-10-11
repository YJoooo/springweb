package a01_diexp.z10_vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Paper {
	private String size;
	@Autowired
	private Pen pen;
	public Paper() {
		// TODO Auto-generated constructor stub
	}
	public void write() {
		System.out.println(size+"사이즈 종이에");
		if(pen!=null) {
			System.out.println(pen.getPrice()+"원 짜리"+pen.getColor()+pen.getKind()+"으로 그림을 그렸다.");
		}else {
			System.out.println("그림 그릴 펜이 없다.");
		}
	}
	public Paper(String size) {
		super();
		this.size = size;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Pen getPen() {
		return pen;
	}
	public void setPen(Pen pen) {
		this.pen = pen;
	}
	
	
}
