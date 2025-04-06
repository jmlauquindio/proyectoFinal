package models;

public class Cliente {
	private String name;
	private String id;
	private int phone;
	private String mail;
	
	
	public Cliente(String name, String id,  int phone, String mail) {
		super();
		this.name = name;
		this.id = id;
		this.phone = phone;
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public int getPhone() {
		return phone;
	}
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
