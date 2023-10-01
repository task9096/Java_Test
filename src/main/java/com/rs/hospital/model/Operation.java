package com.rs.hospital.model;


import javax.persistence.*;

@Entity
@Table(name = "OPERATION")
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OP_ID")
	private long oid;
	
	@Column(name = "OP_NAME")
	private String oName;
	
	@OneToOne
	@JoinColumn(name = "pid")
	private Patient patient;
	
	@OneToOne
	@JoinColumn(name = "DOC_ID")
	private Doctor doctor;
	
	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public String getoName() {
		return oName;
	}

	public void setoName(String oName) {
		this.oName = oName;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	
	
}
