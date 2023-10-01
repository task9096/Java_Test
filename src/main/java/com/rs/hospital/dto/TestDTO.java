package com.rs.hospital.dto;

import com.rs.hospital.model.Doctor;
import com.rs.hospital.model.Test;

import java.util.Date;

public class TestDTO {

	private long tid;
	private String tName;
	private Date tDate;
	private Doctor doctor;
	
	public TestDTO() {
		// TODO Auto-generated constructor stub
	}

	public TestDTO(Test test) {
		super();
		this.tid = test.getTid();
		this.tName = test.gettName();
		this.tDate = test.gettDate();
		this.doctor = test.getDoctor();
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public Date gettDate() {
		return tDate;
	}

	public void settDate(Date tDate) {
		this.tDate = tDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
}
