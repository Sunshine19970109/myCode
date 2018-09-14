package day02;

public class Emp {
	private String name;
	private int age;
	private String sex;
	private int money;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+","+age+","+sex+"money";
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Emp) {
			Emp emp = (Emp)obj;
			if (this.name==emp.name) {
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
}













