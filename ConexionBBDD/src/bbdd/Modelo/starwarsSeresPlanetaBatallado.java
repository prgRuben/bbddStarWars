/**
 * 
 */
package bbdd.Modelo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Rubén
 *
 */
public class starwarsSeresPlanetaBatallado {

	private SimpleIntegerProperty ID;
	private StringProperty Nombre_Ser;
	private StringProperty Facciones; 
	private StringProperty Planeta_Batallado;
	
	public starwarsSeresPlanetaBatallado(int ID,String nombre, String faccion, String planeta) {
		this.ID = new SimpleIntegerProperty(ID);
		this.Nombre_Ser = new SimpleStringProperty(nombre);
		this.Facciones = new SimpleStringProperty(faccion);
		this.Planeta_Batallado = new SimpleStringProperty(planeta);
	}
	
	
	//METODOS SET
	
	public void setNombre_Ser(StringProperty nombre_Ser) {
		this.Nombre_Ser = nombre_Ser;
	}
	public void setFacciones(StringProperty facciones) {
		this.Facciones = facciones;
	}
	public void setPlaneta_Batallado(StringProperty planeta_Batallado) {
		this.Planeta_Batallado = planeta_Batallado;
	}
	public void setNombre (String nombre) {
		this.Nombre_Ser.set(nombre);
	}
	public void setFaccion (String faccion) {
		this.Facciones.set(faccion);
	}
	public void setPlaneta (String planeta) {
		this.Planeta_Batallado.set(planeta);
	}
	
	
	//METODOS GET
	
	public SimpleIntegerProperty getID() {
		return this.ID;
	}
	public StringProperty getNombre_Ser() {
		return Nombre_Ser;
	}
	public StringProperty getNombreSer(starwarsSeresPlanetaBatallado item) {
		String nombreItem = item.Nombre_Ser.getValue();
		String nombrethis = this.Nombre_Ser.getValue();
		if(nombreItem == nombrethis)
			return this.Nombre_Ser;
		else
			return null;
	}
	public StringProperty getPlaneta_Batallado() {
		return Planeta_Batallado;
	}
	public StringProperty getFacciones() {
		return Facciones;
	}
	public String getNombre(String nombre) {
		return this.Nombre_Ser.get();
	}
	public String getPlaneta(String planeta) {
		return this.Planeta_Batallado.get();
	}
	public String getFaccion(String faccion) {
		return this.Facciones.get();
	}
	public StringProperty getNombreSer() {
		return new SimpleStringProperty(this.Nombre_Ser.getValue());
	}
}
