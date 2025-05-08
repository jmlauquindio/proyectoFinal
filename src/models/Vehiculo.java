package models;

public class Vehiculo {
    private String placa;
    private tipoVehiculo TipoVehiculo; 
    private String color;
    private String modelo;

    public Vehiculo(String placa, tipoVehiculo tipoVehiculo, String color, String modelo) {
        this.placa = placa;
        this.TipoVehiculo = tipoVehiculo;
        this.color = color;
        this.modelo = modelo;
    } 
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public tipoVehiculo getTipoVehiculo() {
        return TipoVehiculo;
    }

    public void setTipoVehiculo(tipoVehiculo TipoVehiculo) {
        this.TipoVehiculo = TipoVehiculo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo [placa=" + placa + ", tipoVehiculo=" + TipoVehiculo + ", color=" + color + ", modelo=" + modelo + "]";
    }
}