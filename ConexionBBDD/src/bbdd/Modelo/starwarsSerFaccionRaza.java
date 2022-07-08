/**
 * 
 */
package bbdd.Modelo;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Rubén
 *
 */
public class starwarsSerFaccionRaza {
	
	private StringProperty Nombre;
	private StringProperty Faccion; 
	private StringProperty Raza;

	/**
	 * 
	 */
	public starwarsSerFaccionRaza(String nombre, String faccion, String raza) {
		this.Nombre = new SimpleStringProperty(nombre);
		this.Faccion = new SimpleStringProperty(faccion);
		this.Raza = new SimpleStringProperty(raza);
	}

	

	//METODOS SET
	
	public void setNombre (String nombre) {
		this.Nombre.set(nombre);
	}
	public void setNombreProperty (StringProperty nombre) {
		this.Nombre = nombre;
	}
	public void setFaccion (String faccion) {
		this.Faccion.set(faccion);
	}
	public void setFaccionProperty (StringProperty faccion) {
		this.Faccion = faccion;
	}
	public void setRaza (String raza) {
		this.Raza.set(raza);
	}
	public void setRazaProperty (StringProperty raza) {
		this.Raza = raza;
	}
	
	
	//METODOS GET
	
	public String getNombre (String nombre) {
		return this.Nombre.get();
	}
	public StringProperty getNombreProperty() {
		return this.Nombre;
	}
	public String getFaccion (String faccion) {
		return this.Faccion.get();
	}
	public StringProperty getFaccionProperty() {
		return this.Faccion;
	}
	public String getRaza (String raza) {
		return this.Raza.get();
	}
	public StringProperty getRazaProperty() {
		return this.Raza;
	}
	
}
