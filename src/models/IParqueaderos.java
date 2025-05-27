package models;
import java.util.Map;
public interface IParqueaderos {
	    void configurarDatos(String name, String direccion, String representante, String telefonos);
	    void configurarEspacios(TipoVehiculo tipoVehiculo, int cantidad);
	    void configurarTarifa(TipoVehiculo tipoVehiculo, double tarifaPorHora);
	    boolean hayEspacioDisponible(TipoVehiculo tipoVehiculo);
	    void ocuparEspacio(TipoVehiculo tipoVehiculo);
	    void liberarEspacio(TipoVehiculo tipoVehiculo);
	    double getTarifa(TipoVehiculo tipoVehiculo);
	    Map<String, Integer> getEspaciosDisponibles();

	    String getNaMe();
	    String getDireccion();
	    String getRepresentante();
	    String getTelefonoS();
	}
