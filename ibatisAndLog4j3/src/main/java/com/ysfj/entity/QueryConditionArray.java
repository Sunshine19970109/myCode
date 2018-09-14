package com.ysfj.entity;

import java.util.Arrays;

public class QueryConditionArray {
	private Integer[] stuIds;
	private String name;
	public QueryConditionArray() {
		
	}
	public QueryConditionArray(Integer[] stuIds, String name) {
		super();
		this.stuIds = stuIds;
		this.name = name;
	}
	@Override
	public String toString() {
		return "QueryConditionArray [stuIds=" + Arrays.toString(stuIds) + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(stuIds);
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
		QueryConditionArray other = (QueryConditionArray) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(stuIds, other.stuIds))
			return false;
		return true;
	}
	public Integer[] getStuIds() {
		return stuIds;
	}
	public void setStuIds(Integer[] stuIds) {
		this.stuIds = stuIds;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
