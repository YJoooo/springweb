package a01_diexp.z04_vo;

import org.springframework.stereotype.Component;

// a01_diexp.z01_vo.Hperson
@Component("hps")
public class Hperson {
	private String name;
	private HandPhone handphone;
	public Hperson() {
		// TODO Auto-generated constructor stub
	}
	public Hperson(String name) {
		super();
		this.name = name;
	}
	public void myHandphone(){
		System.out.println("이름:"+name);
		System.out.println(name);
		if(handphone!=null) {
			System.out.println("##소유 핸드폰##");
			System.out.println(handphone.getHnumber());
			System.out.println(handphone.getCompany());
		}else {
			System.out.println("핸드폰 없음.");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HandPhone getHandphone() {
		return handphone;
	}
	public void setHandphone(HandPhone handphone) {
		this.handphone = handphone;
	}
	
}
