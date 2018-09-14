package value;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SomeBean {
	private List<String> rain;
	private Set<String> subject;
	private Map<String,String> friend;
	private Properties stuNum;
	@Override
	public String toString() {
		return "SomeBean [rain=" + rain + ", subject=" + subject + ", friend=" + friend + ", stuNum=" + stuNum + "]";
	}
	public List<String> getRain() {
		return rain;
	}
	public void setRain(List<String> rain) {
		this.rain = rain;
	}
	public Set<String> getSubject() {
		return subject;
	}
	public void setSubject(Set<String> subject) {
		this.subject = subject;
	}
	public Map<String, String> getFriend() {
		return friend;
	}
	public void setFriend(Map<String, String> friend) {
		this.friend = friend;
	}
	public Properties getStuNum() {
		return stuNum;
	}
	public void setStuNum(Properties stuNum) {
		this.stuNum = stuNum;
	}
	public SomeBean() {
		
	}

}
