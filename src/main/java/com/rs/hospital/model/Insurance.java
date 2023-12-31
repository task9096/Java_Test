package com.rs.hospital.model;


import javax.persistence.*;

@Entity
@Table(name = "INSURANCE")
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INS_NO")
	private long iNo;
	
	@Column(name = "INS_AMT")
	private double iAmt;
	
	@Column(name = "INS_EXPIRY")
	private String iExpiryDate;
	
	@OneToOne
	@JoinColumn(name = "pid")
	private Patient patient;

	public long getiNo() {
		return iNo;
	}

	public void setiNo(long iNo) {
		this.iNo = iNo;
	}

	public double getiAmt() {
		return iAmt;
	}

	public void setiAmt(double iAmt) {
		this.iAmt = iAmt;
	}

	public String getiExpiryDate() {
		return iExpiryDate;
	}

	public void setiExpiryDate(String iExpiryDate) {
		this.iExpiryDate = iExpiryDate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	
	
}
