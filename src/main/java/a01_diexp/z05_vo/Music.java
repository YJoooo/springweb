package a01_diexp.z05_vo;
// a01_diexp.z01_vo.Music
public class Music {
	private String mname;
	private String singer;
	public Music() {
		// TODO Auto-generated constructor stub
	}
	public Music(String mname, String singer) {
		super();
		this.mname = mname;
		this.singer = singer;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}

}
