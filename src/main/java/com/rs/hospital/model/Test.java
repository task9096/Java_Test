package com.rs.hospital.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TEST")
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tid")
	private long tid;

	@Column(name = "tName")
	private String tName;

	@Temporal(TemporalType.DATE)
	@Column(name = "tDate")
	private Date tDate;

	@OneToOne
	@JoinColumn(name = "DOC_ID")
	private Doctor doctor;

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

	@Override
	public String toString() {
		return "Test [tid=" + tid + ", tName=" + tName + ", tDate=" + tDate + ", doctor=" + doctor + "]";
	}

	
}
