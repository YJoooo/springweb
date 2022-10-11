package a01_diexp.z02_vo;

public class Computer {
	private String kind;
	private Cpu cpu;
	public Computer() {
		// TODO Auto-generated constructor stub
	}
	public Computer(String kind) {
		super();
		this.kind = kind;
	}
	public void checkComInfo() {
		System.out.print(kind+"컴퓨터의");
		if(cpu!=null) {
			System.out.println("사양은 "+ cpu.getVersion()+"제조회사는"+cpu.getCompany()+"입니다.");
		}else {
			System.out.println("정보는 없습니다.");
		}
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Cpu getCpu() {
		return cpu;
	}
	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}
	
}
