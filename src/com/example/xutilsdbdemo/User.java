package com.example.xutilsdbdemo;

import java.util.Date;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

@Table(name = "user")
public class User {
	@Id
	int id;
	@Column(column = "userid")
	public String userid;
	@Column(column = "name")
	public String name;
	@Column(column = "password")
	public String password;

	public int getId() {
		return this.id;
	}

	public void setUserId(String userid) {
		this.userid = userid;
	}

	public String getUserId() {
		return this.userid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPasword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + getId() + ", name='" + name + '\''
				+ ", password='" + password + '\'' + '}';
	}

}
