package com.demesne.pix.jpa;

import java.util.Date;
import java.sql.Timestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity(name = "memberInfo")
@Table(name = "member_info")
public class MemberInfo extends AbstractEntity{

	
	 @Id
	 @Column(name = "id")
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
	 
	
	@JsonProperty("username")
	@Column(name = "username", unique = true)
	private String userName;
	
	@JsonProperty("firstName")
	@Column(name = "first_name", length = 50)
	private String firstName;

	@JsonProperty("middleName")
	@Column(name = "middle_name", length = 20)
	private String middleName;
	
	@JsonProperty("LastName")
	@Column(name = "last_name", length = 20)
	private String lastName;
	
	@JsonProperty("phone")
	@Column(name = "phone", unique = true, length = 15)
	private Long phone;
	
	@JsonProperty("email")
	@Column(name = "email",unique = true, length = 50)
	private String email;
	
	@JsonProperty("password")
	@Column(name = "password", length = 50)
	private String password;
	
	@JsonProperty("dOB")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "EST")
	@Column(name = "dob")
	private Date dob;

	@JsonProperty("sex")
	@Column(name = "sex")
	private String sex;
	
	@Column(name="is_removed")
	private boolean isRemoved;
	
	public Long getId() {
		return id;
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
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public Long getPhone() {
		return phone;
	}


	public void setPhone(Long phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


	public boolean isRemoved() {
		return isRemoved;
	}


	public void setRemoved(boolean isRemoved) {
		this.isRemoved = isRemoved;
	}

	
}
