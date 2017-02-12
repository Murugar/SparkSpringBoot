package com.iqmsoft.boot.spark.entity;


public class CustomerEntity {

	private long id;
	private String firstName, lastName;

	public CustomerEntity() {
	}

	public CustomerEntity(long id, String first_name, String last_name) {
		this.id = id; this.firstName = first_name;
		this.lastName = last_name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "CustomerEntity{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}
