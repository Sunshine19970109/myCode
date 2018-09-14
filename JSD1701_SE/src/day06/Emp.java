package day06;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Emp {
	private String name;
	private int age;
	private String gender;
	private int salary;
	private String hiredate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public Emp(String name, int age, String gender, int salary, String hiredate) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		
		return this.name+","+this.age+","+
		this.gender+","+this.salary+","+this.hiredate;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Emp) {
			Emp emp = (Emp)obj;
			return this.name==emp.name;
		}else{
			return false;
		}
	}
}















