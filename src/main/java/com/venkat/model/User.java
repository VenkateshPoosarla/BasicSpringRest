package com.venkat.model;

public class User {
	private String id;// UUID
	private String firstName;
	private String middleName;
	private String lastName;
	private Integer age;
	private String gender;// (M or F)
	private String phone;// 10 digit
	private String zip;
	@Override
	public String toString() {
		return "{" + "ID:" + id + ",FIRSTNAME:" + firstName + ",MIDDLENAME:" + middleName + ",LASTNAME:" + lastName
				+ ",AGE:" + age + ",GENDER:" + gender + ",PHONE:" + phone + ",ZIP:" + zip + "}";
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}



}
