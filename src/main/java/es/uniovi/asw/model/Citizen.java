package es.uniovi.asw.model;

import java.util.Date;

public class Citizen {
	
	private Long id;
	private String name;
	private String surname;
	private String mail;
	private Date date;
	private String address;
	private String nationality;
	private String dni;
	
	private String user;
	private String password;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Citizen(String name, String surname, String mail, Date date, String address, String nationality, 
			String dni, String user, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.date = date;
		this.address = address;
		this.nationality = nationality;
		this.dni = dni;
		this.user = user;
		this.password = password;
	}

	public Citizen(String name, String surname, String mail, Date date, String address, String nationality,
			String dni) {
		super();
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.date = date;
		this.address = address;
		this.nationality = nationality;
		this.dni = dni;
	}
	
	
	
}
