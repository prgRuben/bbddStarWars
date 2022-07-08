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
public class starwarsSeresSensibles {

	
	private StringProperty Nombre;
	private StringProperty Sabiduria;
	/**
	 * 
	 */
	public starwarsSeresSensibles(String nombre, String Sabiduria) {
		this.setNombre(new SimpleStringProperty(nombre));
		this.setSabiduria(new SimpleStringProperty(Sabiduria));
	}
	
	
	//METODOS SET


	public void setNombre(String nombre) {
		this.Nombre.set(nombre);
	}
	public void setNombre(StringProperty nombre) {
		this.Nombre = nombre;
	}
	public void setSabiduria(String sabiduria) {
		this.Sabiduria.set(sabiduria);
	}
	public void setSabiduria(StringProperty sabiduria) {
		this.Sabiduria = sabiduria;
	}
	
	
	//METODOS GET
	
	public String getNombre(String nombre) {
		return Nombre.get();
	}
	public StringProperty getNombre() {
		return Nombre;
	}
	public String getSabiduria(String sabiduria) {
		return Nombre.get();
	}
	public StringProperty getSabiduria() {
		return Sabiduria;
	}
	@Override
	   public String toString() {
	       return Nombre.get();
	   }
	
	
	

}
