package models;

public interface IVehiculos {
	    String getPlaca();
	    String getColor();
	    String getModelo();
	    Cliente getPropietario();
	    String getTipo();
	    boolean tieneMembresiaActiva();
	}