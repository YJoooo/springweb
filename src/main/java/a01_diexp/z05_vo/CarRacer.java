package a01_diexp.z05_vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 클래스를 만들고 마지막에는 ctrl+s로 반드시 저장하여야, 실행할 수 있는 컴파일(.class)
// 파일이 생성된다. 외부에서 호출할 떄, 클래스 구성요소가 에러가 나면 이부분을 반드시 점검하세요.
@Component("cr01")
public class CarRacer {
	private String name;
	// @Autowired(required = true) : default 옵션
	// 자동 wiring 처리에 해당 객체가 반드시 있어서 처리되게 하는 옵션
	// 객체가 없으면 에러 발생
	
	// 객체가 컨테이너에 없더라도 에러가 발생하지 않게 선언.
	@Autowired(required = false)
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
