package a01_diexp.z05_vo;

import org.springframework.stereotype.Component;

// a01_diexp.z01_vo.Car
//@Component("c01")
public class Car {
	private String name;
	private int maxspeed;
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public Car(String name, int maxspeed) {
		super();
		this.name = name;
		this.maxspeed = maxspeed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxspeed() {
		return maxspeed;
	}
	public void setMaxspeed(int maxspeed) {
		this.maxspeed = maxspeed;
	}
	

}
