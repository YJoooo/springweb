package a01_diexp.z02_vo;

// 클래스를 만들고 마지막에는 ctrl+s로 반드시 저장하여야, 실행할 수 있는 컴파일(.class)
// 파일이 생성된다. 외부에서 호출할 떄, 클래스 구성요소가 에러가 나면 이부분을 반드시 점검하세요.
public class CarRacer {
	private String name;
	private Car car;
	public CarRacer() {
		// TODO Auto-generated constructor stub
	}
	public CarRacer(String name) {
		super();
		this.name = name;
	}
	public void driving() {
		System.out.print(name+"가 ");
		if(car!=null) {
			System.out.println(car.getName()+" 최고속도 시속"+car.getMaxspeed()+"로 운행합니다.");
		}else {
			System.out.println("자동차 없음.");
		}
	}
	public String getRname() {
		return name;
	}
	public void setRname(String rname) {
		this.name = rname;
	}
	public Car getCar() {
		return car;
	}
	// byName set property를 기준으로 할당된다. car02
	public void setCar02(Car car) {
		this.car = car;
	}

}
