package models;

import java.util.ArrayList;

public class Cliente {
    private String name;
    private String id;
    private String phone;
    private String mail;
    private int age;
    private ArrayList<Vehiculo> vehiculos;

    public Cliente(String name, String id, String phone, String mail, int age) {
        if (name == null || name.isBlank() ||
            id == null || id.isBlank() ||
            phone == null ||
            mail == null || mail.isBlank() ||
            age <= 0) {
            throw new IllegalArgumentException("Datos de cliente inválidos");
        }
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.mail = mail;
        this.age = age;
        this.vehiculos = new ArrayList<>();
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    } 

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void addVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void removeVehiculo(String placa) {
        vehiculos.removeIf(v -> v.getPlaca().equals(placa));
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	@Override
    public String toString() {
        return "Cliente [name=" + name + ", id=" + id + ", phone=" + phone + ", mail=" + mail + ", age=" + age + "]";
    }
    
}