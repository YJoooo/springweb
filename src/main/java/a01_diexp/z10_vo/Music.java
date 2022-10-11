package a01_diexp.z10_vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Music {
	@Value("${music.mname}")
	private String mname;
	@Value("${music.singer}")
	private String singer;
	public Music() {
		// TODO Auto-generated constructor stub
	}
	public void song() {
		System.out.println(singer+"의 타이틀 곡은 "+mname+"입니다.");
	
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
