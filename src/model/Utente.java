package model;

import javax.persistence.Column;

public class Utente {

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String surname;


	public Utente(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
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

	@Override
	public String toString() {
		return "Utente [ name=" + name + ", surname=" + surname + "]";
	}

}
