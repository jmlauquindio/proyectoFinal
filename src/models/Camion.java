package models;

public class Camion extends Vehiculo{

	public Camion(String placa, String color, String modelo, Object membresia, TipoVehiculo tipoVehiculo) {
		super(placa, color, modelo, membresia, tipoVehiculo);
	}	
@Override
public String toString (){
	return "Camion{" +
			"placa='" + placa + '\'' +
			", color='" + color + '\'' +
			", modelo='" + modelo + '\'' +
			", membresia=" + membresia +
			", tipoVehiculo=" + tipoVehiculo +
			'}';
	}
}
