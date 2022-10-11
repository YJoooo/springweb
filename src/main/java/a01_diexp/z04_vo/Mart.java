package a01_diexp.z04_vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mart01")
public class Mart {
	private String name;
	// source 상에 객체가 할당 될 수 있게 선언.
	// container에 해당 객체가 로딩되어 있을 때, 자동으로 할당할 수 있게 처리된다.
	@Autowired
	private Product product;
	public Mart() {
		// TODO Auto-generated constructor stub
	}
	// 이름만 초기화 설정..
	public Mart(String name) {
		super();
		this.name = name;
	}
	public void shopping() {
		System.out.println(name+"에서 구매한 물건");
		if(product!=null) {
			System.out.println("물건명 : "+product.getPname());
			System.out.println("가격 : "+product.getPrice());
			System.out.println("갯수 : "+product.getCnt());
		}else {
			System.out.println("구매한 물건이 없습니다.");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
