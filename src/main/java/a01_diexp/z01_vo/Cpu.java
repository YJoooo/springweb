package a01_diexp.z01_vo;

public class Cpu {
	private String version;
	private String company;
	public Cpu() {
		// TODO Auto-generated constructor stub
	}
	public Cpu(String version, String company) {
		super();
		this.version = version;
		this.company = company;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

}
