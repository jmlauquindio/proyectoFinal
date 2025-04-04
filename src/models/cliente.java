package models;

public class cliente {
	private String name;
	private String id;
	private String placa;
	
	public cliente(String name, String id, String placa) {
		super();
		this.name = name;
		this.id = id;
		this.placa = placa;
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
}
