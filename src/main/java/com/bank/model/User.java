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
		private UserPrimarykey userprimarykey;

		private String password;

		public UserPrimarykey getUserprimarykey() {
			return userprimarykey;
		}

		public void setUserprimarykey(UserPrimarykey userprimarykey) {
			this.userprimarykey = userprimarykey;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public User(UserPrimarykey userprimarykey, String password) {
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


