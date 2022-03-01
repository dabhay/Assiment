package com.bank.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Userprimarykey userprimarykey;

	private String password;

	public Userprimarykey getUserprimarykey() {
		return userprimarykey;
	}

	public void setUserprimarykey(Userprimarykey userprimarykey) {
		this.userprimarykey = userprimarykey;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(Userprimarykey userprimarykey, String password) {
		super();
		this.userprimarykey = userprimarykey;
		this.password = password;
	}

	public User() {

	}

	@Override
	public String toString() {
		return "User [userprimarykey=" + userprimarykey + ", password=" + password + "]";
	}

}
