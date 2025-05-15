package models;

import java.util.ArrayList;

public class Cliente {
    private String name;
    private String id;
    private int phone;
    private String mail;
    private ArrayList<Vehiculo> vehiculos;
    private int edad;

    public Cliente(String name, String id, int phone, String mail, int edad) {
        if (name == null || name.isBlank() ||
            id == null || id.isBlank() ||
            phone <= 0 ||
            mail == null || mail.isBlank() ||
            edad <= 0) {
            throw new IllegalArgumentException("Datos de cliente inválidos");
        }
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.mail = mail;
        this.edad = edad;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    } 

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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

    @Override
    public String toString() {
        return "Cliente [name=" + name + ", id=" + id + ", phone=" + phone + ", mail=" + mail + "]";
    }
    
}