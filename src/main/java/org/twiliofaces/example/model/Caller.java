package org.twiliofaces.example.model;

import java.io.Serializable;

public class Caller implements Serializable {

	private static final long serialVersionUID = 1L;
	private String phoneNumber;
	private String nameUrl;

	public Caller() {
	}

	public Caller(String phoneNumber, String nameUrl) {
		this.phoneNumber = phoneNumber;
		this.nameUrl = nameUrl;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNameUrl() {
		return nameUrl;
	}

	public void setNameUrl(String nameUrl) {
		this.nameUrl = nameUrl;
	}
}
