package a01_diexp.z06_vo;

import org.springframework.stereotype.Component;

@Component
public class Person {
	private String name;
	private int age;
	private String loc;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age, String loc) {
		super();
		this.name = name;
		this.age = age;
		this.loc = loc;
	}
	// get property : getName() ==> Name ==> name 
	//	ex) el ${@@.name}
	public String getName() {
		return name;
	}
	// set property : setName(데이터유형) ==> Name ==> name
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	

}
