package a01_diexp.z01_vo;

public class Note {
	private String kind;
	private Pen pen;
	public Note() {
		// TODO Auto-generated constructor stub
	}
	public Note(String kind) {
		super();
		this.kind = kind;
	}
	public void wirte() {
		System.out.println(kind+"에 ");
		if(pen!=null) {
			System.out.println(pen.getPrice()+"짜리"+pen.getKind()+"으로 글을 썼다.");
		}else {
			System.out.println("쓸 펜이 없다.");
		}
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Pen getPen() {
		return pen;
	}
	public void setPen(Pen pen) {
		this.pen = pen;
	}
	
}
