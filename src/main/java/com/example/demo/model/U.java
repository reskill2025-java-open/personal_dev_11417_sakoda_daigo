package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class U {

	
	private String name;
	
	private String email;
	
	private String address;
	
	private String password;

	private Integer age;
	
	private Integer status;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

				// の中身をすべてクリア
				public void clear() {
					name = null;
					email = null;
					address = null;
					password = null;
					status	= null;
				}
	
}
