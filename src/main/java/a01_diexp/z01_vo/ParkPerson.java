package a01_diexp.z01_vo;

public class ParkPerson {
	private String name;
	private AmusementPark amusementpark;
	public ParkPerson() {
		// TODO Auto-generated constructor stub
	}
	public ParkPerson(String name) {
		super();
		this.name = name;
	}
	public void going() {
		System.out.print(name+"은");
		if(name!=null) {
			System.out.println(amusementpark.getLoc()+"에 위치한 "+amusementpark.getName()+"에 다녀왔다");
		}else {
			System.out.println("놀이동산에 가지 못했다.");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AmusementPark getAmusementpark() {
		return amusementpark;
	}
	public void setAmusementpark(AmusementPark amusementpark) {
		this.amusementpark = amusementpark;
	}
	
}
