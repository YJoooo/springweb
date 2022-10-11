package a01_diexp.z02_vo;

public class Mart {
	private String name;
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
