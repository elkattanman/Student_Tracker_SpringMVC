package com.pgx.java.web.bean;

public class Person {
	private String title;
	private String firstName;
	private String lastName;

	public Person() {}

	public Person(String title, String firstName, String lastName) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
