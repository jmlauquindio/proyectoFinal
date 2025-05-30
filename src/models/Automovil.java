package models;

public class Automovil extends Vehiculo{

	public Automovil(String placa, String color, String modelo, Object membresia, TipoVehiculo tipoVehiculo) {
		super(placa, color, modelo, membresia, tipoVehiculo);
	}	

@Override
public String toString (){
	return "Automovil{" +
			"placa='" + placa + '\'' +
			", color='" + color + '\'' +
			", modelo='" + modelo + '\'' +
			", membresia=" + membresia +
			", tipoVehiculo=" + tipoVehiculo +
			'}';
	}
}
