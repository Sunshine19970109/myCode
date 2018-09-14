package com.ysfj.entity;

import java.util.List;

public class QueryConditionList {
	private List<Customer> lcus;
	private String name;
	public QueryConditionList() {
		
	}
	public QueryConditionList(List<Customer> lcus, String name) {
		super();
		this.lcus = lcus;
		this.name = name;
	}
	@Override
	public String toString() {
		return "QueryConditionList [lcus=" + lcus + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lcus == null) ? 0 : lcus.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QueryConditionList other = (QueryConditionList) obj;
		if (lcus == null) {
			if (other.lcus != null)
				return false;
		} else if (!lcus.equals(other.lcus))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public List<Customer> getLcus() {
		return lcus;
	}
	public void setLcus(List<Customer> lcus) {
		this.lcus = lcus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
