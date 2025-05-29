package interfaces;
import models.Cliente;

public interface IVehiculos {
	    String getPlaca();
	    String getColor();
	    String getModelo();
	    Cliente getPropietario();
	    String getTipo();
	    boolean tieneMembresiaActiva();
	}