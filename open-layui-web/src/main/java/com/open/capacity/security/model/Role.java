package com.open.capacity.security.model;

public class Role extends BaseEntity<Long> {

	private static final long serialVersionUID = -3802292814767103648L;

	private String name;

	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
