package bbdd.Modelo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class starwarsEjercitoFacciones {

	private SimpleIntegerProperty ID;
	private StringProperty Faccion;
	private StringProperty Soldado;
	private StringProperty Vehiculo;
	
	
	public starwarsEjercitoFacciones(int ID, String Faccion, String Soldado, String Vehiculo) {
		this.ID = new SimpleIntegerProperty(ID);
		this.Faccion = new SimpleStringProperty(Faccion);
		this.Soldado = new SimpleStringProperty(Soldado);
		this.Vehiculo = new SimpleStringProperty(Vehiculo);
	}
	
	//METODOS GET
	
	public StringProperty getFacciones() {
		return this.Faccion;
	}
	public String getFacciones(String faccion) {
		return this.Faccion.get();
	}
	public StringProperty getSoldados() {
		return Soldado;
	}
	public String getSoldados(String Soldados) {
		return this.Soldado.get();
	}
	public StringProperty getVehiculos() {
		return Vehiculo;
	}
	public String getVehiculos(String Vehiculos) {
		return this.Vehiculo.get();
	}
	public SimpleIntegerProperty getID() {
		return this.ID;
	}
	public StringProperty getFaccion(starwarsEjercitoFacciones item) {
		String FaccionItem = item.Faccion.getValue();
		String Faccionthis = this.Faccion.getValue();
		if(FaccionItem == Faccionthis)
			return this.Faccion;
		else
			return null;
	}
	public StringProperty getFaccion() {
		return new SimpleStringProperty(this.Faccion.getValue());
	}

	
	
	//METODOS SET
	
	public void setSoldados(StringProperty soldados) {
		this.Soldado = soldados;
	}
	public void setSoldados(String soldados) {
		this.Soldado.set(soldados);
	}
	public void setFacciones(StringProperty facciones) {
		this.Faccion = facciones;
	}
	public void setFacciones(String facciones) {
		this.Faccion.set(facciones);
	}
	public void setVehiculos(StringProperty vehiculos) {
		this.Vehiculo = vehiculos;
	}
	public void setVehiculos(String vehiculos) {
		this.Vehiculo.set(vehiculos);
	}
	public void setID(SimpleIntegerProperty iD) {
		this.ID = iD;
	}

}
