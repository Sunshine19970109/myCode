package entity;

public class Dept {
	private int id;
	private String deptName;
	private String addr;
	@Override
	public String toString() {
		return "Dept [id=" + id + ", deptName=" + deptName + ", addr=" + addr + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}
