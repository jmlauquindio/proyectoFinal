package models;

public class Moto extends Vehiculo{

	public Moto(String placa, String color, String modelo, Object membresia, TipoVehiculo tipoVehiculo) {
		super(placa, color, modelo, membresia, tipoVehiculo);
	}	

@Override
public String toString (){
	return "Moto{" +
			"placa='" + placa + '\'' +
			", color='" + color + '\'' +
			", modelo='" + modelo + '\'' +
			", membresia=" + membresia +
			", tipoVehiculo=" + tipoVehiculo +
			'}';
	}
}
