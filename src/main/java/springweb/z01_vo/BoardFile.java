package springweb.z01_vo;

import java.util.Date;

public class BoardFile {
	private int no;
	private String path;
	private String fname;
	private Date regdte;
	private Date uptdte;
	private String etc;
	public BoardFile() {
		// TODO Auto-generated constructor stub
	}
	public BoardFile(String path, String fname) {
		super();
		this.path = path;
		this.fname = fname;
	}
	public BoardFile(int no, String path, String fname, Date regdte, Date uptdte, String etc) {
		super();
		this.no = no;
		this.path = path;
		this.fname = fname;
		this.regdte = regdte;
		this.uptdte = uptdte;
		this.etc = etc;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public Date getRegdte() {
		return regdte;
	}
	public void setRegdte(Date regdte) {
		this.regdte = regdte;
	}
	public Date getUptdte() {
		return uptdte;
	}
	public void setUptdte(Date uptdte) {
		this.uptdte = uptdte;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}

}
